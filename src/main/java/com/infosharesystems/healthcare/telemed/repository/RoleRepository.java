package com.infosharesystems.healthcare.telemed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosharesystems.healthcare.telemed.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
