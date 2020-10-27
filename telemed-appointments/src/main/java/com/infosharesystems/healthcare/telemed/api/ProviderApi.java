package com.infosharesystems.healthcare.telemed.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosharesystems.healthcare.telemed.common.controller.BaseController;
import com.infosharesystems.healthcare.telemed.dto.request.AddProviderAvailabilityRequest;
import com.infosharesystems.healthcare.telemed.dto.response.AddResponse;
import com.infosharesystems.healthcare.telemed.dto.response.GetResponse;
import com.infosharesystems.healthcare.telemed.service.ProviderService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/provider")
@Api(tags = {"Provider API"})
public class ProviderApi extends BaseController{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderApi.class);

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public AddResponse saveProvider(@RequestBody AddProviderAvailabilityRequest request) {

		LOGGER.info("Rest API /provider/create/update POST invoked with data '{}'", request);
		final long start = System.currentTimeMillis();
		AddResponse response = new AddResponse();
		try {
			Long providerId = providerService.saveProviderAvailability(request);
			response.setId(providerId);
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /provider/create/update POST. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /provider/create/update POST.");
			prepareFailureResponse(response, e);
		}
		return response;
	}

	

	@RequestMapping(value = "/get-providers", method = RequestMethod.GET)
	public GetResponse getAllProviders() {
		LOGGER.info("Rest API /get-providers invoked to retrieve all providers");
		GetResponse response = new GetResponse();
		final long start = System.currentTimeMillis();
		try {
			response.setResponse(providerService.getProviders());
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /get-providers. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /get-providers.");
			prepareFailureResponse(response, e);
		}
		return response;
	}
}
