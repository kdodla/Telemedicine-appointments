package com.infosharesystems.healthcare.telemed.api;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosharesystems.healthcare.telemed.dto.EmailInfo;
import com.infosharesystems.healthcare.telemed.service.EmailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/email")
@Api(tags = { "email-service API" })
public class EmailApi {

	protected Logger logger = Logger.getLogger(EmailApi.class.getName());

	@Autowired
	private EmailService emailService;

	@ApiOperation(value = "Send an email")
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public void sendEmail(@RequestBody @Valid EmailInfo emailInfo1) {
		logger.info(String.format("email.sendEmail(%s)", emailInfo1));
		emailService.sendEmail(emailInfo1);
	}

}
