package com.jewellery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewellery.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByEmailAndAdminPassPin(String email, String adminPassPin);

}
