
package com.infosharesystems.healthcare.telemed.dto.request;

import java.util.List;

import com.infosharesystems.healthcare.telemed.dto.AppointmentDetailsDTO;
import com.infosharesystems.healthcare.telemed.dto.FamilyMemberDTO;
import com.infosharesystems.healthcare.telemed.dto.InsuranceDetailsDTO;
import com.infosharesystems.healthcare.telemed.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class BookAppointmentRequest {

	private MemberDTO member;
	//private List<FamilyMemberDTO> familyMembers;
	private InsuranceDetailsDTO insuranceDetails;
	private AppointmentDetailsDTO appointment;
}
