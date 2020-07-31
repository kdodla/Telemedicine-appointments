package com.infosharesystems.healthcare.telemed.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infosharesystems.healthcare.telemed.dto.ProviderAvailabilityDTO;
import com.infosharesystems.healthcare.telemed.dto.ProviderDTO;
import com.infosharesystems.healthcare.telemed.dto.request.AddProviderAvailabilityRequest;
import com.infosharesystems.healthcare.telemed.exception.CommonException;
import com.infosharesystems.healthcare.telemed.model.ProviderAvailability;
import com.infosharesystems.healthcare.telemed.repository.ProviderRepository;

@Component
public class ProviderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderService.class);

	@Autowired
	private ProviderRepository providerRepository;

	public Long saveProviderAvailability(AddProviderAvailabilityRequest request) {

		LOGGER.info("Entered addOrUpdateConsultingPatient('{}')", request);
		long providerId = 0;

		try {
			// prepare Patient Object
			ProviderAvailability providerAvailability = _prepareProviderAvailabilityObject(
					request.getProviderAvailabilityDTO());
			// save to DB
			providerAvailability = providerRepository.save(providerAvailability);

			providerId = providerAvailability.getProviderId();
		} catch (Exception e) {
			LOGGER.info("ProviderCreationFailedException occurred.", e);
			throw new CommonException("ProviderCreationFailedException", "");
		}
		return providerId;
	}

	public ProviderAvailability _prepareProviderAvailabilityObject(ProviderAvailabilityDTO request) {

		LOGGER.info("Entered _prepareProviderAvailabilityObject('{}')");
		ProviderAvailability providerAvailability = null;
		
		if (request.getId() != 0) {
			// if the user is found, update the existing record
			providerAvailability = providerRepository.findByProviderId(request.getId());
		}
		if (providerAvailability == null) {
			// else create a new one
			providerAvailability = new ProviderAvailability();
		}

		providerAvailability.setDoctorName(request.getDoctorName());
		providerAvailability.setAppointmentDates(request.getAppointmentDates());
		providerAvailability.setAppointmentSlots(request.getAppointmentSlots());
		providerAvailability.setQualification(request.getQualification());
		providerAvailability.setRecurring(request.isRecurring());
		providerAvailability.setSpecialities(request.getSpecialities());
		providerAvailability.setTimeZones(request.getTimeZones());

		return providerAvailability;
	}
	
	

	public List<ProviderDTO> getProviders() {

		LOGGER.info("Entered getProviders('{}')");
		List<Object[]> providers = null;
		List<ProviderDTO> providerDTO = new ArrayList<ProviderDTO>();
		try {
			providers = providerRepository.getProviders();

			// doesn't exist?
			if (providers == null) {
				LOGGER.warn("Could not find providers: '{}'");
				// throw new ProvidersNotFoundException("");
			} else {
				LOGGER.info("Providers '{}' found ");
				for (Object[] providerObject : providers) {

					providerDTO.add(mapDomainObjectToDTO(providerObject[0], providerObject[1]));

				}
				return providerDTO;
			}
		} catch (Exception e) {
			LOGGER.warn("Could not find the providers.", e);
			throw new CommonException("ProvidersNotFoundException", "");
		}

		return null;
	}

	
	
	public ProviderDTO mapDomainObjectToDTO(Object providerId, Object providerName) {

		LOGGER.info("Entered mapDomainObjectToDTO('{}')");

		ProviderDTO providerDTO = new ProviderDTO();
		providerDTO.setProviderId((Long) providerId);
		providerDTO.setProviderName((String) providerName);

		return providerDTO;

	}

	public List<ProviderAvailabilityDTO> getProviderAvailabilities(Long doctorId) {

		List<ProviderAvailabilityDTO> providerAvailabilityDTO = new ArrayList<ProviderAvailabilityDTO>();

		List<Object[]> appointmentSlots = providerRepository.appointmentSlots(doctorId);

		int addedDays = 0;
		while (addedDays < 60) {
			LocalDate date = LocalDate.now().plusDays(addedDays);

			for (Object[] appointmentDaysAndSlots : appointmentSlots) {

				if (appointmentDaysAndSlots[0].equals("MON-SAT")) {

					if (!(date.getDayOfWeek() == DayOfWeek.SUNDAY)) {
						providerAvailabilityDTO.add(mapDomainObjectToDTO(date, appointmentDaysAndSlots[1]));
					}
					++addedDays;

				}

				if (appointmentDaysAndSlots[0].equals("MON|WED|SAT")) {

					if ((date.getDayOfWeek() == DayOfWeek.MONDAY) || (date.getDayOfWeek() == DayOfWeek.WEDNESDAY)
							|| (date.getDayOfWeek() == DayOfWeek.SATURDAY)) {
						providerAvailabilityDTO.add(mapDomainObjectToDTO(date, appointmentDaysAndSlots[1]));
					}
					++addedDays;

				}
			}
		}

		return providerAvailabilityDTO;

	}
	
	

	private ProviderAvailabilityDTO mapDomainObjectToDTO(LocalDate date, Object appointmentDaysAndSlots) {

////				StringBuffer sb = new StringBuffer(date.toString());
////				sb.append(String.valueOf(appointmentDaysAndSlots));
//		
//				String s = date.toString();	
//				String str = String.valueOf(appointmentDaysAndSlots);
//				String[] arrOfStr = str.split("-");
//				String stri = arrOfStr[0];
//				String[] arrOfStri = stri.split(" ");
//				String strin = arrOfStr[0];
//				String[] arrOfStrin = stri.split(":");
//		
//				
//				////////////////////////////////////////////////////////////////////////////////
//				 int gapInMinutes =  30 ;  // Define your span-of-time.
//				    int loops = ( (int) Duration.ofHours( 24 ).toMinutes() / gapInMinutes ) ;
//				    List<LocalTime> times = new ArrayList<>( loops ) ;
//				 
//				    //LocalTime time = LocalTime.MIN ;  // '00:00'
//				    
//				    LocalTime time = LocalTime.of((Integer)arrOfStrin[0],30);
//				    
//				    for( int i = 1 ; i <= loops ; i ++ ) {
//				        times.add( time ) ;
//				        // Set up next loop.
//				        time = time.plusMinutes( gapInMinutes ) ;
//				    }
//				 
//				    System.out.println( times.size() + " time slots: " ) ;
//				    System.out.println( times );
//				    //////////////////////////////////////////////////////////////////////////////
//				    
//				    
//				String s1 = s.concat(" ");
//				String s2 = s1.concat(String.valueOf(arrOfStr[1]));
//				System.out.println(s2);
//				 ZoneId zoneId = ZoneId.systemDefault();
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
//				//Date dat = formatter.parse(s2);
//				s2 = s2.replace(" PM", "");
//				LocalDateTime dateTime = LocalDateTime.parse(s2, formatter);
//				System.out.println(dateTime);
//				 ZonedDateTime zonedDateTime = dateTime.atZone(zoneId);
//		
//				 Date dat = Date.from(zonedDateTime.toInstant());
//				System.out.println(dat);
//				SimpleDateFormat formatte = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");  
//				 String   strDate = formatte.format(dat);  
//				    System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : "+strDate);
//				ProviderAvailabilityDTO ProviderAvailabilityDTO = new ProviderAvailabilityDTO();
//		
//				ProviderAvailabilityDTO.setAvailableDateAndSlots(strDate);
//				
//				System.out.println(ProviderAvailabilityDTO.getAvailableDateAndSlots());
		return null;

	}

}
