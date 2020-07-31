package com.infosharesystems.healthcare.telemed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosharesystems.healthcare.telemed.model.User;

public interface UserRepositoty extends JpaRepository<User, Long> {

}
