package com.jewellery.adminController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jewellery.model.Admin;
import com.jewellery.service.AdminService;
import com.jewellery.utils.ConstantAction;
import com.jewellery.utils.IConstant;



@RestControllerAdvice
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(ConstantAction.SAVE_ADMIN_DETAILS)
	public Map<Object,Object> saveAdminDetail(@RequestBody Admin admin)
	{
		Map<Object, Object> map = new HashMap<>();
		Admin oldAdmin = adminService.saveAdminDetail(admin);
		if (null != oldAdmin) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.OBJECT, oldAdmin);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.ERROR_MESSAGE);
		}
		return map;
		
	}
	
	@CrossOrigin
	@PostMapping(ConstantAction.ADMIN_LOGIN)
	public Map<Object,Object> adminLogin(@RequestBody Admin admin)
	{
		Map<Object, Object> map = new HashMap<>();
		Admin oldAdmin = adminService.adminLogin(admin);
		if (null != oldAdmin) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.MESSAGE, IConstant.LOGIN_MESSAGE);
			map.put(IConstant.OBJECT, oldAdmin);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.EMAIL_PASSWORD_INCORRECT);
		}
		return map;
		
	}
	
	
}
