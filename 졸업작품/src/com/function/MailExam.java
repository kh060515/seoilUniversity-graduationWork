package com.function;

import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class MailExam {
	public static void main(String email,String sentence) {
		try {
			new MailExam(email,sentence);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	public MailExam(String email,String sentence) throws Exception{
		
		Properties props=new Properties();
		
		props.setProperty("mail.transport.protocol","smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		
		Authenticator auth=new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javamailt1@gmail.com","helsink1!");
				//����� ������ ���̵� ��й�ȣ �Է�
			}
		};
		Session session=Session.getDefaultInstance(props, auth);
		
		MimeMessage message=new MimeMessage(session);
		message.setSender(new InternetAddress("javamailt1@gmail.com"));
		message.setSubject("인증번호 입니다.");	//제목
		
		message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
		//�޴� ��� ����
		Multipart mp=new MimeMultipart();
		MimeBodyPart mbp1=new MimeBodyPart();
		mbp1.setText(sentence);
		mp.addBodyPart(mbp1);
		
		MailcapCommandMap mc=(MailcapCommandMap) CommandMap.getDefaultCommandMap();
		mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc.addMailcap("multipart/*;;x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc.addMailcap("text/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		
		message.setContent(mp);
		
		Transport.send(message);
	}
}
