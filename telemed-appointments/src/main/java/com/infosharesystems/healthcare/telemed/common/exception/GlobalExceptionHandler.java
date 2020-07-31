
package com.infosharesystems.healthcare.telemed.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infosharesystems.healthcare.telemed.common.response.BaseResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MultipartException.class)
	@ResponseBody
	BaseResponse handleFileException(HttpServletRequest request, Throwable ex) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setSuccessFlag(false);
		baseResponse.setErrorMsg("uploaded file is too large");
		return baseResponse;
	}
}
