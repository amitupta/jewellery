package com.jewellery.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.model.ProductType;
import com.jewellery.repository.ProductTypeRepository;
import com.jewellery.service.ProductTypeService;
import com.jewellery.utils.IConstant;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeRepository productTypeRepository;
	private static final Logger logger = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

	@Override
	public ProductType saveProductTypeDetail(ProductType productType) {
		ProductType oldProductType = null;
		try {
			oldProductType = productTypeRepository.save(productType);

		} catch (Exception e) {
			logger.error("saveProductTypeDetail in ProductTypeServiceImpl--", e);
			oldProductType = null;
		}
		return oldProductType;
	}

	@Override
	public List<ProductType> getAllActiveProductType() {
		List<ProductType> productTypes = null;
		try {
			productTypes = productTypeRepository.findByIsActive(IConstant.ZERO);
		} catch (Exception e) {
			logger.error("getAllActiveProductType in ProductTypeServiceImpl--", e);
			productTypes = null;
		}
		return productTypes;
	}

}
