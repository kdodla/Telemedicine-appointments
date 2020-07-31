
package com.infosharesystems.healthcare.telemed.dto.response;

import com.infosharesystems.healthcare.telemed.common.response.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data@EqualsAndHashCode(callSuper=true)@ToString
public class AddResponse extends BaseResponse {

	private static final long serialVersionUID = -3123627523447352903L;
	
	private long id;
}
