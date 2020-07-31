package com.infosharesystems.healthcare.telemed.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.infosharesystems.healthcare.telemed.dto.EmailInfo;
import com.infosharesystems.healthcare.telemed.exception.CommonException;

/**
 * @author shravan
 *
 */
@Service
public class EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(EmailInfo emailInfo) {
	  try {
		  LOGGER.info("SendEmail invoked with data '{}'", emailInfo);
		  SimpleMailMessage email = new SimpleMailMessage();
		  email.setTo(emailInfo.getEmailTo());
		  email.setFrom("social@scatterfit.com");
		  email.setCc(emailInfo.getCcTo());
		  email.setSubject(emailInfo.getSubject());
		  email.setText(emailInfo.getBody());
		  mailSender.send(email);
		  LOGGER.info("email sent to...."+emailInfo.getEmailTo());
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw new CommonException("Email sending faild...",emailInfo.getEmailTo());
	  }
	}

}
