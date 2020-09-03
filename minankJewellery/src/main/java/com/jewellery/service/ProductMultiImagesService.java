package com.jewellery.service;

import org.springframework.web.multipart.MultipartFile;

import com.jewellery.model.ProductMultiImages;

public interface ProductMultiImagesService {

	ProductMultiImages uploadImageDetail(MultipartFile multipartFile, ProductMultiImages oldproductMultiImages);

	
}
