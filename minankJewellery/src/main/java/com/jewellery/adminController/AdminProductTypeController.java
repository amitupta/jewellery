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

import com.jewellery.model.ProductType;
import com.jewellery.service.ProductTypeService;
import com.jewellery.utils.ConstantAction;
import com.jewellery.utils.IConstant;

@RestControllerAdvice
@RequestMapping("/admin")
public class AdminProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;
	
	@PostMapping(ConstantAction.SAVE_PRODUCT_TYPE_DETAILS)
	public Map<Object,Object> saveProductTypeDetail(@RequestBody ProductType productType)
	{
		Map<Object, Object> map = new HashMap<>();
		ProductType oldProductType = productTypeService.saveProductTypeDetail(productType);
		if (null != oldProductType) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.OBJECT, oldProductType);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.ERROR_MESSAGE);
		}
		return map;
		
	}
	
	
	@GetMapping(ConstantAction.GET_ALL_ACTIVE_PRODUCT_TYPE)
	public Map<Object,Object> getAllActiveProductType()
	{
		Map<Object, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeService.getAllActiveProductType();
		if (null != productTypes) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.OBJECT, productTypes);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.DATA_NOT_FOUND);
		}
		return map;
		
	}

}
