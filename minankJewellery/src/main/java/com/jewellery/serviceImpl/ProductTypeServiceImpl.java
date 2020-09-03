package com.jewellery.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.model.ProductType;
import com.jewellery.repository.ProductTypeRepository;
import com.jewellery.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductType saveProductTypeDetail(ProductType productType) {
		return productTypeRepository.save(productType);
	}

}
