package com.infosharesystems.healthcare.telemed.dto.response;

import com.infosharesystems.healthcare.telemed.common.response.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data@EqualsAndHashCode(callSuper=true)@ToString
public class AddAppointmentsResponse extends BaseResponse { /**
	 * 
	 */
	private static final long serialVersionUID = -409783472466217630L;
	
	private Long patientId;



}
