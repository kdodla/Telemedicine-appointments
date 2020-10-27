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


@Data@EqualsAndHashCode(callSuper=false)@ToString
@Entity
@Table(name = "provider")
public class ProviderAvailability extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private Long providerId;
	@Column(name = "doctor_name")
	private String doctorName;
	@Column(name = "appointment_dates")
	private String appointmentDates;
	@Column(name = "appointments_slots")
	private String appointmentSlots;
	@Column(name = "time_zones")
	private String timeZones;
	@Column(name = "recurring")
	private boolean recurring;
	@Column(name = "specialities")
	private String specialities;
	@Column(name = "qualification")
	private String qualification;

}
