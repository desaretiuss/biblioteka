package org.ikubinfo.biblioteka.utility;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSender {

	private static String HOST = "smtp.gmail.com";
	private static String USER = "flediymerasi@gmail.com";
	private static String PASSWORD = "alkohol1993";
	private static String PORT = "587";
	private static String FROM = "flediymerasi@gmail.com";

	private static String STARTTLS = "true";
	private static String AUTH = "true";
	private static String DEBUG = "true";
	private static String SUBJECT = "Njoftim";

	public static void sendActivationEmail(String receiver, String activation_code) {

		String tokenUrl = "http://localhost:8080/biblioteka/confirm?emailID=" + receiver + "&confirmID="
				+ activation_code;

		String TEXT = "Përshëndetje! Për të aktivizuar llogarinë tuaj në sistemin elektronik të bibliotekës, "
				+ " klikoni, ju lutemi, në linkun: " + tokenUrl;

		// Use Properties object to set environment properties
		Properties props = new Properties();

		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.user", USER);

		props.put("mail.smtp.auth", AUTH);
		props.put("mail.smtp.starttls.enable", STARTTLS);
		props.put("mail.smtp.debug", DEBUG);

		try {

			// Obtain the default mail session
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(true);

			// Construct the mail message
			MimeMessage message = new MimeMessage(session);
			message.setText(TEXT);
			message.setSubject(SUBJECT);
			message.setFrom(new InternetAddress(FROM));
			message.addRecipient(RecipientType.TO, new InternetAddress(receiver));
			message.saveChanges();

			// Use Transport to deliver the message
			Transport transport = session.getTransport("smtp");
			transport.connect(HOST, USER, PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
