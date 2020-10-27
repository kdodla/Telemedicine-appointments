package com.infosharesystems.healthcare.telemed.common.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class FeignClientException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public FeignClientException(int status, String reason) {
		super(status+": " + reason);
	}
	
}
