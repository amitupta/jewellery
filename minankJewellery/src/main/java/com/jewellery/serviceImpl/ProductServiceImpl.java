package com.jewellery.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jewellery.model.Product;
import com.jewellery.model.ProductMultiImages;
import com.jewellery.repository.ProductMultiImagesRepository;
import com.jewellery.repository.ProductRepository;
import com.jewellery.service.ProductMultiImagesService;
import com.jewellery.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMultiImagesRepository productMultiImagesRepository;

	@Autowired
	private ProductMultiImagesService multiImagesService;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Product saveProductDetail(Product product, MultipartFile[] files) {
		Product oldProduct = null;
		Product updateProductDetails = null;
		List<ProductMultiImages> multiImages = new ArrayList<ProductMultiImages>();
		try {
			oldProduct = productRepository.save(product);
			if (null != oldProduct) {
				for (int i = 0; i < files.length; i++) {
					ProductMultiImages oldProductMultiImages = new ProductMultiImages();
					oldProductMultiImages = productMultiImagesRepository.save(new ProductMultiImages());
					ProductMultiImages productMultiImages = multiImagesService.uploadImageDetail(files[i],
							oldProductMultiImages);
					if (null != productMultiImages) {
						multiImages.add(productMultiImages); 
					}
				}
				oldProduct.setProductMultiImages(multiImages);
				oldProduct.setUpdationDate(new Date());
				updateProductDetails = productRepository.save(oldProduct);
				if (null != updateProductDetails) {
					return updateProductDetails;
				}
			}

		} catch (Exception e) {
			logger.error("saveProductDetail in ProductServiceImpl--", e);
			updateProductDetails = null;
		}
		return updateProductDetails;
	}

}
