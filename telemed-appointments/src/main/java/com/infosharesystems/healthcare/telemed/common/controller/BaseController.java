package com.infosharesystems.healthcare.telemed.common.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.infosharesystems.healthcare.telemed.common.constants.ErrorCodes;
import com.infosharesystems.healthcare.telemed.common.exception.InputValidationException;
import com.infosharesystems.healthcare.telemed.common.exception.TelemedicineException;
import com.infosharesystems.healthcare.telemed.common.response.BaseResponse;
import com.infosharesystems.healthcare.telemed.common.util.ViewMapper;

public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected ViewMapper viewMapper;
	
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();
	
	/*@Value("${application.host}")
	private String host;

	protected String getApplicationHost() {
		return host;
	}*/

	protected void prepareFailureResponse(BaseResponse baseResponse, Exception e) {

		baseResponse.setSuccessFlag(false);
		if (e instanceof TelemedicineException) {
			LOGGER.warn("Expected Exception occurred while serving Rest API ", e);
			baseResponse.setErrorCode(((TelemedicineException) e).getErrorCode());
			baseResponse.setErrorMsg(e.getMessage());
		} else {
			LOGGER.error("Exception occurred while serving Rest API ", e);
			// exceptions
			baseResponse.setErrorCode(ErrorCodes.GENERIC_EXCEPTION);
			baseResponse.setErrorMsg("Error processing request.");
		}
	}

	protected ResponseEntity<byte[]> prepareFileFailureResponse(Exception e) {

		if (e instanceof TelemedicineException) {
			LOGGER.warn("Expected Exception occurred while serving Rest API ", e);
		} else {
			LOGGER.error("Exception occurred while serving Rest API ", e);
		}
		return new ResponseEntity<byte[]>(HttpStatus.NO_CONTENT);
	}

	protected void validate(Object obj) {

		Set<ConstraintViolation<Object>> violations = validator.validate(obj);
		LOGGER.debug("Validation of {} result: {}", obj, violations);
		if (violations != null && !violations.isEmpty()) {
			LOGGER.info("Validation errors for {} are: {}", obj, violations);
			throw new InputValidationException();
		}
	}
}
