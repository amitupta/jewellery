package com.jewellery.adminController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jewellery.model.ProductSubType;
import com.jewellery.model.ProductType;
import com.jewellery.service.ProductSubTypeService;
import com.jewellery.utils.ConstantAction;
import com.jewellery.utils.IConstant;

@RestControllerAdvice
@RequestMapping("/admin")
public class AdminProductSubTypeController {
	@Autowired
	private ProductSubTypeService productSubTypeService;
	
	@PostMapping(ConstantAction.SAVE_PRODUCT_SUB_TYPE_DETAILS)
	public Map<Object,Object> saveProductSubTypeDetail(@RequestBody List<ProductSubType> productSubType)
	{
		Map<Object, Object> map = new HashMap<>();
		List<ProductSubType> oldProductSubType = productSubTypeService.saveProductSubTypeDetail(productSubType);
		if (null != oldProductSubType) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.OBJECT, oldProductSubType);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.ERROR_MESSAGE);
		}
		return map;
		
	}
	
	@GetMapping(ConstantAction.GET_ALL_ACTIVE_SUB_PRODUCT_TYPE)
	public Map<Object,Object> getAllActiveSubProductType()
	{
		Map<Object, Object> map = new HashMap<>();
		List<ProductSubType> productSubTypes = productSubTypeService.getAllActiveSubProductType();
		if (null != productSubTypes) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.OBJECT, productSubTypes);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.DATA_NOT_FOUND);
		}
		return map;
		
	}


}
