package com.infosharesystems.healthcare.telemed.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AppointmentDetailsDTO {

	private String providerId;

	private String providerName;

	private String timezone;

	private String appointmentStartTime;

	private String duration;

	private String durationUnit;

	private String appointmentNote;

}
