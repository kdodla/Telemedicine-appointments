package com.infosharesystems.healthcare.telemed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosharesystems.healthcare.telemed.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
