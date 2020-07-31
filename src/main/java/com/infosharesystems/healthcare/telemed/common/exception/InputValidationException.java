
package com.infosharesystems.healthcare.telemed.common.exception;

import com.infosharesystems.healthcare.telemed.common.constants.ErrorCodes;

public class InputValidationException extends RuntimeException implements TelemedicineException {

	private static final long serialVersionUID = 3173726815256007810L;

	public InputValidationException() {

		super("Input Validation failed for REST API input");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.INPUT_VALIDATION_EXCEPTION;
	}
}
