package org.ikubinfo.biblioteka.model;

public class Member {

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int mobile;
	private String birthdate;
	private String address;
	private String category;
	private byte[] passwordEncrypted;
	private byte[] passwordSalt;
	private String activationCode;
    private byte[] activationSalt;
    
	public byte[] getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(byte[] passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getActivationSalt() {
		return activationSalt;
	}

	public void setActivationSalt(byte[] activationSalt) {
		this.activationSalt = activationSalt;
	}

}
