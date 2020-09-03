package com.jewellery.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.model.Admin;
import com.jewellery.repository.AdminRepository;
import com.jewellery.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveAdminDetail(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin adminLogin(Admin admin) {
		return adminRepository.findByEmailAndAdminPassPin(admin.getEmail(),admin.getAdminPassPin());
	}
}
