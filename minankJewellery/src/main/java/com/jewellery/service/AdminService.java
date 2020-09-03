package com.jewellery.service;

import com.jewellery.model.Admin;

public interface AdminService {

	Admin saveAdminDetail(Admin admin);

	Admin adminLogin(Admin admin);

}
