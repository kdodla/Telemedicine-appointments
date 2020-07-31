package com.infosharesystems.healthcare.telemed.dto.request;

import com.infosharesystems.healthcare.telemed.dto.ProviderAvailabilityDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddProviderAvailabilityRequest {
	

	private ProviderAvailabilityDTO providerAvailabilityDTO;
	

}
