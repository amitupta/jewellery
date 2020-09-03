package com.jewellery.service;

import org.springframework.web.multipart.MultipartFile;

import com.jewellery.model.Product;

public interface ProductService {

	Product saveProductDetail(Product oldProduct, MultipartFile[] files);

}
