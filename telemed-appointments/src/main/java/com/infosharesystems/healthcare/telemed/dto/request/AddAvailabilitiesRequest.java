
package com.infosharesystems.healthcare.telemed.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.infosharesystems.healthcare.telemed.dto.AvailabilityDTO;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class AddAvailabilitiesRequest {

	private List<AvailabilityDTO> availabilities = new ArrayList<AvailabilityDTO>();

}
