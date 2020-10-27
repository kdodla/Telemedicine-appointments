
package com.infosharesystems.healthcare.telemed.common.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = -6953627518777352903L;
	private boolean successFlag = true;
	private String errorCode;
	private String errorMsg;

}
