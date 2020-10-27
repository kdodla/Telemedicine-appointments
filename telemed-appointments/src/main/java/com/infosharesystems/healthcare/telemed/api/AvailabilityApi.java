package com.infosharesystems.healthcare.telemed.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosharesystems.healthcare.telemed.common.controller.BaseController;
import com.infosharesystems.healthcare.telemed.dto.request.AddAvailabilitiesRequest;
import com.infosharesystems.healthcare.telemed.dto.request.SearchAppointments;
import com.infosharesystems.healthcare.telemed.dto.response.GetResponse;
import com.infosharesystems.healthcare.telemed.service.AvailabilityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/availability")
@Api(tags = {"Appointment API"})
public class AvailabilityApi extends BaseController {

	@Autowired
	private AvailabilityService availabilityService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AvailabilityApi.class);
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Save provider appointment availability", notes = "You need to provide valid availability details.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Returns the response of the newly created id") })
	public GetResponse save(@RequestBody AddAvailabilitiesRequest request) {
		LOGGER.info("Rest API /api/v1/appointments POST invoked with data '{}'", request);
		final long start = System.currentTimeMillis();
		GetResponse response = new GetResponse();
		try {
			List<Long> ids = request.getAvailabilities().stream()
					.map(dto -> availabilityService.addOrUpdateAvailability(dto)).collect(Collectors.toList());
			response.setResponse(ids);
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /api/v1/appointments POST. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /api/v1/appointments POST.");
			prepareFailureResponse(response, e);
		}
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get the appointments")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns the response provider appointments") })
	public GetResponse getAvailabilities() {
		LOGGER.info("Rest API /api/v1/appointments GET invoked with data '{}'");
		final long start = System.currentTimeMillis();
		GetResponse response = new GetResponse();
		try {
			response.setResponse(availabilityService.getAvailabilities());
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /api/v1/appointments GET. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /api/v1/appointments GET.");
			prepareFailureResponse(response, e);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get the provider appointments based on available/scheduled/display")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns the response provider appointments") })
	public GetResponse getAvailabilitiesByType(@RequestParam("type") String type) {
		LOGGER.info("Rest API /api/v1/appointments/{type} GET invoked with data '{}'", type);
		final long start = System.currentTimeMillis();
		GetResponse response = new GetResponse();
		try {
			response.setResponse(Arrays.asList(availabilityService.getAvailabilityByType(type)));
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /api/v1/appointments/{type} GET. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /api/v1/appointments/{type} GET.");
			prepareFailureResponse(response, e);
		}
		return response;
	}

	@RequestMapping(value = "/{availabilityId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get the provider availability")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns the response provider availabilities") })
	public GetResponse getAvailability(@PathVariable("availabilityId") long availabilityId) {
		LOGGER.info("Rest API /api/v1/appointments/{availabilityId} GET invoked with data '{}'", availabilityId);
		final long start = System.currentTimeMillis();
		GetResponse response = new GetResponse();
		try {
			response.setResponse(Arrays.asList(availabilityService.getAvailabilityById(availabilityId)));
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /api/v1/appointments/{availabilityId} GET. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /api/v1/appointments/{availabilityId} GET.");
			prepareFailureResponse(response, e);
		}
		return response;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Search/Filter and get the appointments")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns the response provider appointments") })
	public GetResponse search(@RequestBody SearchAppointments request) {
		LOGGER.info("Rest API /api/v1/appointments/search POST invoked with data '{}'");
		final long start = System.currentTimeMillis();
		GetResponse response = new GetResponse();
		try {
			response.setResponse(availabilityService.getAppointments());
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /api/v1/appointments/search POST. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /api/v1/appointments/search POST.");
			prepareFailureResponse(response, e);
		}
		return response;
	}
}
