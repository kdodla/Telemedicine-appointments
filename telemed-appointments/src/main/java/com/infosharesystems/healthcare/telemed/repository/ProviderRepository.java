package com.infosharesystems.healthcare.telemed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosharesystems.healthcare.telemed.model.ProviderAvailability;

public interface ProviderRepository extends JpaRepository<ProviderAvailability, Long> {

	
	public ProviderAvailability findByProviderId(Long id);
	
	@Query("SELECT p.providerId,p.doctorName FROM ProviderAvailability p")
	public List<Object[]> getProviders();
	
	
	@Query("SELECT p.appointmentDates,p.appointmentSlots FROM ProviderAvailability p WHERE p.id = ?1")
	public List<Object[]> appointmentSlots(Long doctorId);

	
}
