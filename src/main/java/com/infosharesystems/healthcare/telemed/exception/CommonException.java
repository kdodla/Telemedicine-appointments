package com.infosharesystems.healthcare.telemed.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.infosharesystems.healthcare.telemed.common.exception.TelemedicineException;

@ResponseStatus(org.springframework.http.HttpStatus.EXPECTATION_FAILED)
public class CommonException extends RuntimeException implements TelemedicineException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;

	public CommonException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	@Override
	public String getErrorCode() {
		return this.errorCode;
	}
}
