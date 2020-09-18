package com.jewellery.service;

import java.util.List;

import com.jewellery.model.ProductType;

public interface ProductTypeService {

	ProductType saveProductTypeDetail(ProductType productType);

	List<ProductType> getAllActiveProductType();

}
