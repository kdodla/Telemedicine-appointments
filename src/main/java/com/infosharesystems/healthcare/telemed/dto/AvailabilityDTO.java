
package com.infosharesystems.healthcare.telemed.dto;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class AvailabilityDTO {

	private long availabilityId;
	private String title;
	private String start;
	private String end;
	private String type = "Available";
	private Boolean allDay = Boolean.FALSE;
	private String groupId;
	private String backgroundColor = "#008055";
	private String rendering = "background";
	private String scheduleType;
	private String timezone;
	private String scheduleStatus;
	private String timeSlotStart;
	private String timeSlotEnd;
}
