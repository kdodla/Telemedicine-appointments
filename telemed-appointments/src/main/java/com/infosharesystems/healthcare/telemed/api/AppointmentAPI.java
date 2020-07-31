package com.infosharesystems.healthcare.telemed.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosharesystems.healthcare.telemed.common.controller.BaseController;
import com.infosharesystems.healthcare.telemed.dto.AppointmentDetailsDTO;
import com.infosharesystems.healthcare.telemed.dto.request.BookAppointmentRequest;
import com.infosharesystems.healthcare.telemed.dto.response.AddAppointmentsResponse;
import com.infosharesystems.healthcare.telemed.dto.response.GetAppointmentsResponse;
import com.infosharesystems.healthcare.telemed.service.AppointmentService;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentAPI extends BaseController {

	@Autowired
	private AppointmentService appointmentService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentAPI.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AddAppointmentsResponse saveBookAppointment(@RequestBody BookAppointmentRequest request) {

		LOGGER.info("Rest API /bookAppointment/create POST invoked with data '{}'", request);
		final long start = System.currentTimeMillis();
		AddAppointmentsResponse response = new AddAppointmentsResponse();
		try {
			Long patientId = appointmentService.saveAppointment(request);
			response.setPatientId(patientId);
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /saveBookAppointment/create POST. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /saveBookAppointment/create POST.");
			prepareFailureResponse(response, e);
		}
		return response;
	}
	

	@RequestMapping(value = "/upcommingAppointments/{doctorId}", method = RequestMethod.GET)
	public GetAppointmentsResponse upcommingAppointments(@PathVariable("doctorId") String doctorId) {

		LOGGER.info("Rest API /provider/create/update POST invoked with data '{}'", doctorId);
		final long start = System.currentTimeMillis();
		GetAppointmentsResponse response = new GetAppointmentsResponse();
		try {
			List<AppointmentDetailsDTO> appointmentDetailsDTO = appointmentService.getUpcommingAppointments(doctorId);
			response.setResponse(appointmentDetailsDTO);
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /upcommingAppointments. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /upcommingAppointments.");
			prepareFailureResponse(response, e);
		}
		return response;
	}

}
