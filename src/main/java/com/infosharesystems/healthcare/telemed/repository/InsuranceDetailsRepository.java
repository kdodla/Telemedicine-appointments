package com.infosharesystems.healthcare.telemed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosharesystems.healthcare.telemed.model.InsuranceDetails;



public interface InsuranceDetailsRepository extends JpaRepository<InsuranceDetails, Long> {

}
