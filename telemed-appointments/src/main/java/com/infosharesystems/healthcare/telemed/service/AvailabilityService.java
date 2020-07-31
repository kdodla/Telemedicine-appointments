package com.infosharesystems.healthcare.telemed.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infosharesystems.healthcare.telemed.common.service.BaseService;
import com.infosharesystems.healthcare.telemed.common.util.ViewMapper;
import com.infosharesystems.healthcare.telemed.dto.AppointmentDTO;
import com.infosharesystems.healthcare.telemed.dto.AvailabilityDTO;
import com.infosharesystems.healthcare.telemed.exception.CommonException;
import com.infosharesystems.healthcare.telemed.model.Availability;
import com.infosharesystems.healthcare.telemed.repository.AvailabilityRepository;


@Component
public class AvailabilityService extends BaseService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AvailabilityService.class);
	
	@Autowired
	private AvailabilityRepository availabilityRepo;
	
	@Autowired
	protected ViewMapper viewMapper;
	
	public long addOrUpdateAvailability(AvailabilityDTO dto) {
		LOGGER.info("Entered addOrUpdateUser('{}')", dto);
		long availabilityId = 0;
		try {
			Availability availability = viewMapper.map(dto, Availability.class);
			if (dto.getAvailabilityId() != 0) {
				// if the record found, update the existing record
				LOGGER.info("Updating Record ('{}')", dto.getAvailabilityId());
				availabilityRepo.findOne(dto.getAvailabilityId());
				availability.setModifiedBy("1");
			} else {
				LOGGER.info("Creating Record starting from ('{}')", dto.getStart());
				availability.setCreatedBy("1");
				availability.setModifiedBy("1");
			}
				// create to DB
				availability = availabilityRepo.save(availability);
				availabilityId = availability.getAvailabilityId();
		} catch (Exception e) {
			LOGGER.info("CommonException occurred.", e);
			throw new CommonException("AddOrUpdateAvailability failed","");
		}
		LOGGER.info("Successfully returning addOrUpdateAvailability('{}')", availabilityId);
		return availabilityId;
	}

	
	public List<AvailabilityDTO> getAvailabilityByType(String type) {
		LOGGER.info("Entered getAvailabilityByType('{}')", type);
		List<AvailabilityDTO> availabilityDTOs = null;
		try {
			List<Availability> availabilities = availabilityRepo.findByType(type);
			// doesn't exist?
			if (availabilities == null) {
				LOGGER.warn("Could not found records: '{}'");
				throw new CommonException("Could not found records", "");
			} else {
				LOGGER.info("User '{}' found ");
				availabilityDTOs = viewMapper.mapList(availabilities, AvailabilityDTO.class);
			}
		} catch (Exception e) {
			LOGGER.warn("Could not find the records.", e);
			throw new CommonException("Could not found records", type+"");
		}		
		return availabilityDTOs;
	}

	
	public List<AvailabilityDTO> getAvailabilities() {
		LOGGER.info("Entered getAvailabilities('{}')");
		List<AvailabilityDTO> availabilityDTOs = null;
		try {
			List<Availability> availabilities = availabilityRepo.findAll();
			// doesn't exist?
			if (availabilities == null) {
				LOGGER.warn("Could not found records: '{}'");
				throw new CommonException("Could not found records", "");
			} else {
				LOGGER.info("User '{}' found ");
				availabilityDTOs = viewMapper.mapList(availabilities, AvailabilityDTO.class);
				/*
				 * availabilityDTOs.forEach(dto -> { dto.set });
				 */
			}
		} catch (Exception e) {
			LOGGER.warn("Could not find the records.", e);
			throw new CommonException("Could not found records", "");
		}
		return availabilityDTOs;
	}

	public AvailabilityDTO getAvailabilityById(long availabilityId) {
		LOGGER.info("Entered getAvailabilityById('{}')", availabilityId);
		AvailabilityDTO availabilityDTO = null;
		try {
			Availability availability = availabilityRepo.findOne(availabilityId);
			// doesn't exist?
			if (availability == null) {
				LOGGER.warn("Could not find record for availabilityId: '{}'", availabilityId);
				throw new CommonException("Could not found record", availabilityId+"");
			} else {			
				LOGGER.info("Record '{}' found ", availabilityId);
				availabilityDTO = viewMapper.map(availability, AvailabilityDTO.class);
			}
		} catch (Exception e) {
			LOGGER.warn("Could not find the record.", e);
			throw new CommonException("Could not found record", availabilityId+"");
		}		
		return availabilityDTO;
	}

	public List<AppointmentDTO> getAppointments() {
		LOGGER.info("Entered getAppointments('{}')");
		List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();
		AppointmentDTO app = new AppointmentDTO();
		app.setFirstName("Test");
		app.setLastName("");
		appointmentDTOs.add(app);
		try {
			List<Availability> availabilities = availabilityRepo.findAll();
			// doesn't exist?
			if (availabilities == null) {
				LOGGER.warn("Could not found records: '{}'");
				throw new CommonException("Could not found records", "");
			} else {
				LOGGER.info("User '{}' found ");
				//appointmentDTOs = viewMapper.mapList(availabilities, AvailabilityDTO.class);
				/*
				 * availabilityDTOs.forEach(dto -> { dto.set });
				 */
			}
		} catch (Exception e) {
			LOGGER.warn("Could not find the records.", e);
			throw new CommonException("Could not found records", "");
		}
		return appointmentDTOs;
	}
}
