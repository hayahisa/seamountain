package mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

public class NewRegistMail {
	
	 private final static String mailServerHost = System.getenv("MAIL_SERVER_HOST");
	    private final static String mailServerPort = System.getenv("MAIL_SERVER_PORT");
	    private final static String mailUserAddress = System.getenv("MAIL_USER_ADDRESS");
	    private final static String mailUserName = System.getenv("MAIL_USER_NAME");
	    private final static String mailUserPassword = System.getenv("MAIL_USER_PASSWORD");
	    private final static String mailCharset = "UTF-8";
	    
	    public NewRegistMail() {
			// TODO 自動生成されたコンストラクター・スタブ
		}
	    
	    private static String decorateContent(String content) {
	        return content +
	                "\n" +
	                "\n" +
	                "｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ\n" +
	                "登録を完了するためにURLを押下してください\n" +
	                "http://localhost:8080/SeaMountain/UserRegistrationConfirm" +
	                "\n" +
	                "※ このメールへの返信はできませんのでご了承ください。\n" +
	                "｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ+｡｡.｡･.｡*ﾟ\n";
	    }

	    public static void sendMail(String subject, String content, String dstAddr) throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", mailServerHost);
	        properties.put("mail.smtp.port", mailServerPort);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.connectiontimeout", "10000");
	        properties.put("mail.smtp.timeout", "10000");
	        properties.put("mail.debug", "true");

	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(mailUserAddress, mailUserPassword);
	            }
	        });

	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(mailUserAddress, mailUserName));
	        message.setRecipients(RecipientType.TO, dstAddr);
	        message.setSubject(subject, mailCharset);
	        message.setText(decorateContent(content), mailCharset);

	        Transport.send(message);
	    }
}
