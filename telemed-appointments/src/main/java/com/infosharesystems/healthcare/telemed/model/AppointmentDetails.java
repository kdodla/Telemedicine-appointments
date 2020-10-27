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

@Entity
@Table(name = "appointment_details")
@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDetails extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Long scheduleId;
	@Column(name = "provider_id")
	private String providerId;
    @Column(name = "provider_name")
	private String providerName;
    @Column(name = "timezone")
	private String timezone;
    @Column(name = "appointmentStartTime")
	private String appointmentStartTime;
    @Column(name = "duration")
	private String duration;
    @Column(name = "durationUnit")
	private String durationUnit;
    @Column(name = "appointmentNote")
	private String appointmentNote;
	

}
