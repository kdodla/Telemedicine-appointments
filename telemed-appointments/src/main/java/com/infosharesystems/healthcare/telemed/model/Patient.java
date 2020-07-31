package com.infosharesystems.healthcare.telemed.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infosharesystems.healthcare.telemed.common.entity.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data@EqualsAndHashCode(callSuper=false)@ToString
@Entity
@Table(name = "patient")
public class Patient extends AbstractEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Long patientId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "patient_age")
	private String patientAge;
	@Column(name = "patient_gender")
	private String patientGender;
	@Column(name = "email")
	private String email;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "insurance_details_id")
	private Long insuranceDetailsId;
	@Column(name = "appointment_details_id")
	private Long appointmentDetailsId;
	
	
	
	public Patient() {
	
	}
	
	public Patient( String firstName, String lastName, String middleName, String patientAge,
			String patientGender, String email, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	
	
	
	
	

}
