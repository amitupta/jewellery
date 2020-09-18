package com.jewellery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jewellery.model.Product;

public interface ProductService {

	Product saveProductDetail(Product oldProduct, MultipartFile[] files);

	List<Product> getAllActiveProduct();

}
