package com.infosharesystems.healthcare.telemed.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infosharesystems.healthcare.telemed.common.service.BaseService;
import com.infosharesystems.healthcare.telemed.common.util.ViewMapper;
import com.infosharesystems.healthcare.telemed.dto.AppointmentDetailsDTO;
import com.infosharesystems.healthcare.telemed.dto.InsuranceDetailsDTO;
import com.infosharesystems.healthcare.telemed.dto.MemberDTO;
import com.infosharesystems.healthcare.telemed.dto.request.BookAppointmentRequest;
import com.infosharesystems.healthcare.telemed.exception.CommonException;
import com.infosharesystems.healthcare.telemed.model.AppointmentDetails;
import com.infosharesystems.healthcare.telemed.model.InsuranceDetails;
import com.infosharesystems.healthcare.telemed.model.Patient;
import com.infosharesystems.healthcare.telemed.repository.AppointmentDetailsRepository;
import com.infosharesystems.healthcare.telemed.repository.InsuranceDetailsRepository;
import com.infosharesystems.healthcare.telemed.repository.PatientRepository;

@Component
public class AppointmentService extends BaseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentService.class);

	@Autowired
	private ViewMapper viewMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private InsuranceDetailsRepository insuranceDetailsRepository;

	@Autowired
	private AppointmentDetailsRepository appointmentDetailsRepository;

	public Long saveAppointment(BookAppointmentRequest request) {

		LOGGER.info("Entered saveAppointment('{}')", request);
		// long patientId = 0;

		try {
			// prepare Patient Object
			Patient patient = _preparePatientObject(request.getMember());
			// prepare InsuranceDetails Object
			InsuranceDetails insuranceDetails = _prepareInsuranceDetailsObject(request.getInsuranceDetails());
			// prepare AppoinmentsDetails Object
			AppointmentDetails appointmentDetails = _prepareAppointmentDetailsObject(request.getAppointment());

			// save to Patient DB
			patientRepository.save(patient);
			// save to InsuranceDetails DB
			insuranceDetailsRepository.save(insuranceDetails);
			// save to AppointmentDetails DB
			appointmentDetailsRepository.save(appointmentDetails);

		} catch (Exception e) {
			LOGGER.info("CommonException occurred.", e);
			throw new CommonException("saveAppointment failed", "");
		}
		LOGGER.info("Successfully returning saveAppointment('{}')");
		
		return null;
	}

	private Patient _preparePatientObject(MemberDTO member) {

		LOGGER.info("Entered _preparePatientObject('{}')");
		Patient patient = new Patient();

		patient.setFirstName(member.getFirstName());
		patient.setMiddleName(member.getMiddleName());
		patient.setLastName(member.getLastName());
		patient.setEmail(member.getEmail());
		patient.setContactNumber(member.getContactNumber());
		patient.setPatientGender(member.getGender());
		patient.setPatientAge(member.getAge());
		patient.setInsuranceDetailsId(member.getInsuranceDetailsId());
		patient.setAppointmentDetailsId(member.getAppointmentDetailsId());

		// TODO Auto-generated method stub
		return patient;

	}

	private AppointmentDetails _prepareAppointmentDetailsObject(AppointmentDetailsDTO appointment) {

		LOGGER.info("Entered _prepareAppointmentDetailsObject('{}')");
		System.out.println(appointment.toString());

		AppointmentDetails appointmentDetails = viewMapper.map(appointment, AppointmentDetails.class);

		System.out.println(appointmentDetails.toString());

		// TODO Auto-generated method stub
		return appointmentDetails;
	}

	private InsuranceDetails _prepareInsuranceDetailsObject(InsuranceDetailsDTO insuranceDetailsDTO) {

		LOGGER.info("Entered _prepareInsuranceDetailsObject('{}')");

		System.out.println(insuranceDetailsDTO.toString());
		InsuranceDetails insuranceDetail = viewMapper.map(insuranceDetailsDTO, InsuranceDetails.class);
		System.out.println(insuranceDetail.toString());

		// TODO Auto-generated method stub
		return insuranceDetail;
	}
	

	public List<AppointmentDetailsDTO> getUpcommingAppointments(String doctorId) {

		LOGGER.info("Entered getUpcommingAppointments('{}')", doctorId);

		List<AppointmentDetailsDTO> appointmentDetailsDTO = new ArrayList<AppointmentDetailsDTO>();
		try {
			List<AppointmentDetails> appointmentDetails = appointmentDetailsRepository.findByProviderId(doctorId);
			// doesn't exist?
			if (appointmentDetails == null) {
				LOGGER.warn("Could not found records: '{}'");
				throw new CommonException("Could not found records", "");
			} else {
				LOGGER.info("Appointments '{}' found ");

				for (AppointmentDetails ad : appointmentDetails) {

					if (LocalDate.now().toString().equals(_dateTimestampToString(ad.getCreatedDate()))) {
						appointmentDetailsDTO.add(viewMapper.map(ad, AppointmentDetailsDTO.class));
					}

				}
			}
		} catch (Exception e) {
			LOGGER.warn("Could not find the records.", e);
			throw new CommonException("Could not found records", doctorId);
		}
		return appointmentDetailsDTO;
	}

}
