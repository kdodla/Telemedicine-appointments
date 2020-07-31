package com.infosharesystems.healthcare.telemed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infosharesystems.healthcare.telemed.common.entity.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data@EqualsAndHashCode(callSuper = false)@ToString
@Entity
@Table(name = "insurance_details")
public class InsuranceDetails extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "insurance_id")
	private Long insuranceId;
	@Column(name = "member_id")
	private String memberID;
	@Column(name = "group_name")
	private String group;
	@Column(name = "benefit_plan")
	private String benefitPlan;
	@Column(name = "effective_date")
	private String effectiveDate;
	@Column(name = "insurance_notes")
	private String insuranceNotes;
	
	
	public InsuranceDetails() {
		
	}
	
	
	public InsuranceDetails(String memberID, String group, String benefitPlan, String effectiveDate,
			String insuranceNotes) {
		super();
		this.memberID = memberID;
		this.group = group;
		this.benefitPlan = benefitPlan;
		this.effectiveDate = effectiveDate;
		this.insuranceNotes = insuranceNotes;
	}
	
	
	
	
	
	
	
	

}
