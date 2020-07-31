package com.infosharesystems.healthcare.telemed.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class EmailInfo {

	@NotNull(message = "EmailTo is a required field and must not be null/empty")
	private String emailTo;
	private String ccTo;
	private String emailFrom;
	private String subject;
	private String body;
}
