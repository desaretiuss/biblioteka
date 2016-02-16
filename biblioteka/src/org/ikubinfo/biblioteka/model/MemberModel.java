package org.ikubinfo.biblioteka.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ikubinfo.biblioteka.utility.EmailSender;
import org.ikubinfo.biblioteka.utility.EncryptionService;
import org.ikubinfo.biblioteka.utility.JavaWebTokenUtility;

public class MemberModel extends DatabaseConnection {

	/**
	 * Shton te dhenat e perdoruesit ne databaze. Dergon email konfirmimi me
	 * linkun e aktivizmit nqs te dhenat u shtuan pa problem ne databaze.
	 * 
	 * @param member
	 * 
	 * @return boolean
	 * @throws NoSuchAlgorithmException
	 */
	public boolean addNewMember(Member member) {

		boolean result = false;

		provideEncryption(member);

		if (writeNewMemberToDatabase(member)) {

			result = true;
			// Perdoruesit i dergohet nje mesazh konfirmimi npm email-it.
			EmailSender.sendActivationEmail(member.getEmail(), member.getActivationCode());

		}

		return result;

	}

	public boolean activateAccount(String confirmID, String email) {

		boolean result = false;

		if (JavaWebTokenUtility.authenticateJWT(confirmID, getActivationSalt(email))) {

			setEnabledToMemberInDatabase(email);
			result = true;

		} else {
			// Nqs me siper rezulton se kodi i verifikimit eshte i pasakte,
			// aktivizimi i llogarise deshtohet dhe perdoruesi fshihet nga
			// databaza.
			rollbackMember(email);

		}

		return result;

	}

	private void setEnabledToMemberInDatabase(String email) {

		PreparedStatement st = null;

		try {

			String sql = " UPDATE `library_database`.`member` " + " SET `member_account_enabled`=? "
					+ " WHERE `member_email`=?";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setBoolean(1, true);
			st.setString(2, email);

			st.executeUpdate();

			st.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	/**
	 * Fshi perdoruesin nga databaza.
	 * 
	 * @param email
	 *            Emaili i perdoruesit.
	 */
	public void rollbackMember(String email) {

		PreparedStatement st = null;

		try {

			String sql = " DELETE FROM `library_database`.`member` WHERE member_email=?;";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, email);

			st.executeUpdate();

			st.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public byte[] getActivationSalt(String email) {

		byte[] salt = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		try {

			String sql = "SELECT `member_activation_salt` FROM `library_database`.`member` WHERE `member_email`=?";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, email);

			rs = st.executeQuery();

			while (rs.next()) {

				salt = rs.getBytes("member_activation_salt");

			}

			st.close();
			rs.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return salt;

	}

	/**
	 * Enkripton fjalekalimin. Gjeneron kod-aktivizimi.
	 * 
	 * @param member
	 */
	public void provideEncryption(Member member) {
		try {
			member.setPasswordSalt(EncryptionService.generateSalt());
			member.setPasswordEncrypted(
					EncryptionService.getEncryptedPassword(member.getPassword(), member.getPasswordSalt()));

			member.setActivationSalt(EncryptionService.generateSalt());
			member.setActivationCode(JavaWebTokenUtility.generateActivationCode(member.getEmail(),
					System.currentTimeMillis(), member.getActivationSalt()));

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
			e1.printStackTrace();
		}

	}

	public boolean writeNewMemberToDatabase(Member member) {

		boolean result = false;

		PreparedStatement st = null;

		try {

			String sql = " INSERT INTO `library_database`.`member`( " + "`member_firstname`, " + "`member_lastname`, "
					+ "`member_email`, " + "`member_mobile`, " + "`member_birthdate`, " + "`member_address`, "
					+ "`member_category`, " + "`member_password`, " + "`member_password_salt`, "
					+ "`member_activation_code`, `member_activation_salt` ) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, member.getFirstname());
			st.setString(2, member.getLastname());
			st.setString(3, member.getEmail());
			st.setInt(4, member.getMobile());
			st.setString(5, member.getBirthdate());
			st.setString(6, member.getAddress());
			st.setString(7, member.getCategory());
			st.setBytes(8, member.getPasswordEncrypted());
			st.setBytes(9, member.getPasswordSalt());
			st.setString(10, member.getActivationCode());
			st.setBytes(11, member.getActivationSalt());

			if (st.executeUpdate() == 0) {
				result = false;
			} else {
				result = true;
			}

			st.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return result;

	}

	public boolean doesEmailExists(String email) {

		boolean emailExists = false;

		ResultSet rs = null;
		PreparedStatement st = null;

		try {

			String sql = "SELECT * FROM `library_database`.`member` WHERE `member_email`=?";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, email);

			rs = st.executeQuery();

			if (rs.isBeforeFirst()) {
				emailExists = true;
			}

			st.close();
			rs.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return emailExists;
	}

	/**
	 * Kontrollon nese ekziston anetari.
	 * 
	 * @param email
	 * @param pass
	 * @return true nqs gjendet nje anetar me keto kredenciale.
	 */
	public boolean doesMemberExists(String email, String userPass) {

		boolean memberExists = false;

		byte[][] encryption = getEncryptedData(email);
		byte[] salt = encryption[1];
		byte[] encryptedPassword = encryption[0];

		try {
			memberExists = EncryptionService.authenticate(userPass, encryptedPassword, salt);
			// memberExists=true;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {

			e.printStackTrace();
		}

		return memberExists;
	}

	/**
	 * Kthen password-in dhe salt-in qe i perket anetarit me kete email.
	 * 
	 * @param email
	 * @return byte[][] encrytpedData ([[salt][password]]
	 */
	public byte[][] getEncryptedData(String email) {

		ResultSet rs = null;
		byte[][] encryption = new byte[2][];
		PreparedStatement st = null;

		try {

			String sql = "SELECT `member_encrypted_password`, `member_password_salt` FROM `library_database`.`member` WHERE `member_email`=?";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, email);

			rs = st.executeQuery();

			while (rs.next()) {

				encryption[0] = rs.getBytes("member_password");
				encryption[1] = rs.getBytes("member_password_salt");

			}

			st.close();
			rs.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return encryption;
	}

}