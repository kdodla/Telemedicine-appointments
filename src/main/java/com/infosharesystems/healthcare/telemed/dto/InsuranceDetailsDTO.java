package com.infosharesystems.healthcare.telemed.dto;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class InsuranceDetailsDTO {

	private String memberID;

    private String group;

    private String benefitPlan;

    private String effectiveDate;

    private String insuranceNotes;

}
