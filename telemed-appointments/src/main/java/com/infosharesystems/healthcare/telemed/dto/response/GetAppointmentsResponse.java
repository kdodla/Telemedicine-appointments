package com.infosharesystems.healthcare.telemed.dto.response;

import java.util.List;

import com.infosharesystems.healthcare.telemed.common.response.BaseResponse;
import com.infosharesystems.healthcare.telemed.dto.AppointmentDetailsDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data@EqualsAndHashCode(callSuper=true)@ToString
public class GetAppointmentsResponse extends BaseResponse {/**
	 * 
	 */
	private static final long serialVersionUID = -2554765401086592234L;
	
	private List<AppointmentDetailsDTO> response;

}
