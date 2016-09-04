package com.mail.smtp;

import javax.mail.MessagingException;

public interface SendEmail {

	void send(String to, String subject, String body) throws MessagingException;

}