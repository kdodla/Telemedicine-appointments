package com.infosharesystems.healthcare.telemed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosharesystems.healthcare.telemed.model.AppointmentDetails;

public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails, Long> {

	List<AppointmentDetails> findByProviderId(String doctorId);

}
