package com.jewellery.adminController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

import com.jewellery.model.Product;
import com.jewellery.service.ProductService;
import com.jewellery.utils.ConstantAction;
import com.jewellery.utils.IConstant;

@RestControllerAdvice
@RequestMapping("/admin")
public class AdminProductController {
	@Autowired
	private ProductService productService;

	@PostMapping(ConstantAction.SAVE_PRODUCT_DETAILS)
	public Map<Object, Object> saveProductDetail(@RequestParam(value = "files", required = false) MultipartFile[] files,
			Product product) {
		Map<Object, Object> map = new HashMap<>();
		Product oldProduct = productService.saveProductDetail(product, files);
		if (null != oldProduct) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_CODE);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.OBJECT, oldProduct);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_CODE);
			map.put(IConstant.MESSAGE, IConstant.ERROR_MESSAGE);
		}
		return map;

	}

}
