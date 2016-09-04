package com.mail.smtp;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
@Qualifier("smtp")
public class SmptMailSender implements SendEmail   {
	/* (non-Javadoc)
	 * @see com.mail.smtp.SendEmail#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		
		MimeMessage message =javaMailSender.createMimeMessage();
		MimeMessageHelper helper ; 
		helper=new MimeMessageHelper(message ,true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);
		javaMailSender.send(message);

	}
}
