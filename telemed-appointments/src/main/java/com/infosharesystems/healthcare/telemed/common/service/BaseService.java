package com.infosharesystems.healthcare.telemed.common.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Timestamp _todaysDateWithStartTime(){
		LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		LocalDateTime startOfDay = today.atStartOfDay();//
		//LOGGER.info("Today's startOfDay '{}'", startOfDay);
		return Timestamp.valueOf(startOfDay);
	}

	public Timestamp _todaysDateWithEndTime(){
		LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		LocalDateTime endOfDate = today.atTime(LocalTime.MAX);
		//LOGGER.info("Today's endOfDate '{}'", endOfDate);
		return Timestamp.valueOf(endOfDate);
	}

	public Timestamp _todaysDateWithStartTime(LocalDate today){
		if(today == null) {
			today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		}
		LocalDateTime startOfDay = today.atStartOfDay();//
		//LOGGER.info("Today's startOfDay '{}'", startOfDay);
		return Timestamp.valueOf(startOfDay);
	}

	public Timestamp _todaysDateWithEndTime(LocalDate today){
		if(today == null) {
			today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		}
		LocalDateTime endOfDate = today.atTime(LocalTime.MAX);
		//LOGGER.info("Today's endOfDate '{}'", endOfDate);
		return Timestamp.valueOf(endOfDate);
	}

	public Timestamp _dateStringToTimestamp(String day) {
		// LOGGER.debug("_dateStringToTimestamp string_date '{}'\t:"+day);
		LocalDate localDate = LocalDate.parse(day, dtf);
		LOGGER.debug("before converting into timestamp\t:" + localDate);
		return Timestamp.valueOf(localDate.atStartOfDay());
	}

	public String _dateTimestampToString(Timestamp date) {
		LocalDate localDate = date.toLocalDateTime().toLocalDate();
		LOGGER.debug("before converting into string\t:" + localDate);
		return localDate.format(dtf);
	}

	public String _dateDateToString(Date date) {
		LOGGER.debug("before converting into string\t:" + date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public String _dateToString(Date date, String format) {
		LOGGER.debug("before converting into string\t:{}", date);
		return new SimpleDateFormat(format).format(date);
	}

	public boolean _nullCheck(String str) {
		return (str != null && !str.isEmpty());
	}

	public boolean _nullCheck(Collection<?> obj) {
		return (obj != null && !obj.isEmpty());
	}

	public boolean _nullCheck(Object obj) {
		return (obj != null);
	}
}
