package com.infosharesystems.healthcare.telemed.dto.request;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class SearchAppointments {

	private String fromDate;

    private String toDate;

    private String providerName;

    private String search;

}
