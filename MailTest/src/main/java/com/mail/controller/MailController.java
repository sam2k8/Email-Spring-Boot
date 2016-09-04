package com.mail.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.smtp.SendEmail;

@RestController
public class MailController {
	
	private SendEmail sendEmail;
	
	@Autowired
	public MailController(@Qualifier("smtp")SendEmail sendEmail) {
		this.sendEmail = sendEmail;
	}

	@RequestMapping("/")
	public String home() {
		try {
			sendEmail.send("s.sayem@ymail.com", "test Mail", "Bro You have Done it");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello World";
			
	}

}
