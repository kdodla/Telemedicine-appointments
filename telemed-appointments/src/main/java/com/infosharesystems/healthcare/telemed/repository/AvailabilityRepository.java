
package com.infosharesystems.healthcare.telemed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosharesystems.healthcare.telemed.model.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

	List<Availability> findByType(String type);
}
