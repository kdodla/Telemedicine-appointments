package com.infosharesystems.healthcare.telemed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.infosharesystems.healthcare.telemed.common.entity.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data@EqualsAndHashCode(callSuper=false)@ToString
@Entity
@Table(name = "availability")
public class Availability extends AbstractEntity{
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable=false)
	private long availabilityId;
	@Column(name = "title")
	private String title;
	@Column(name = "start")
	private String start;
	@Column(name = "end")
	private String end;
	@Column(name = "type")
	private String type;
	@Column(name = "all_day")
	private Boolean allDay = Boolean.FALSE;
	@Column(name = "group_id")
	private String groupId;
	@Column(name = "schedule_type")
	private String scheduleType;
	@Column(name = "timezone")
	private String timezone;
	@Column(name = "schedule_status")
	private String scheduleStatus;
	@Column(name = "time_slot_start")
	private String timeSlotStart;
	@Column(name = "time_slot_end")
	private String timeSlotEnd;
}
