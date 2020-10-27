package com.infosharesystems.healthcare.telemed.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProviderAvailabilityDTO {

	private Long id;
	private String doctorName;
	private String appointmentDates;
	private String appointmentSlots;
	private String timeZones;
	private boolean recurring;
	private String specialities;
	private String qualification;

	// private String availableDateAndSlots;

}
