package com.jewellery.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.model.ProductSubType;
import com.jewellery.model.ProductType;
import com.jewellery.repository.ProductSubTypeRepository;
import com.jewellery.service.ProductSubTypeService;
import com.jewellery.utils.IConstant;

@Service
public class ProductSubTypeServiceImpl implements ProductSubTypeService {
	@Autowired
	private ProductSubTypeRepository productSubTypeRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductSubTypeServiceImpl.class);

	@Override
	public List<ProductSubType> saveProductSubTypeDetail(List<ProductSubType> productSubType) {
		List<ProductSubType> oldProductSubTypes = null;
		try {
			oldProductSubTypes = productSubTypeRepository.saveAll(productSubType);
			if (!oldProductSubTypes.isEmpty()) {
				return oldProductSubTypes;
			}
		} catch (Exception e) {
			logger.error("saveProductSubTypeDetail in ProductSubTypeServiceImpl---", e);
			oldProductSubTypes = null;
		}
		return oldProductSubTypes;
	}

	@Override
	public List<ProductSubType> getAllActiveSubProductType() {
		List<ProductSubType> productSubTypes = null;
		try {
			productSubTypes = productSubTypeRepository.findByIsActive(IConstant.ZERO);
		} catch (Exception e) {
			logger.error("getAllActiveSubProductType in ProductTypeServiceImpl--", e);
			productSubTypes = null;
		}
		return productSubTypes;
	}

}
