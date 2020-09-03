package com.jewellery.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jewellery.model.ProductMultiImages;
import com.jewellery.repository.ProductMultiImagesRepository;
import com.jewellery.service.ProductMultiImagesService;
import com.jewellery.utils.ConvertImage;

@Service
public class ProductMultiImagesServiceImpl implements ProductMultiImagesService {
	@Autowired
	private ProductMultiImagesRepository productMultiImagesRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductMultiImagesServiceImpl.class);

	@Override
	public ProductMultiImages uploadImageDetail(MultipartFile multipartFile, ProductMultiImages oldproductMultiImages) {
		try {
			ConvertImage convertImage = new ConvertImage();
			List<String> listFiles = convertImage.saveSingleImages(multipartFile,
					oldproductMultiImages.getProductImageId());
			String imagePath = "";
			for (int i = 0; i <= listFiles.size() - 1; i++) {
				if (i == 0) {
					imagePath = listFiles.get(i);
				}
			}
			oldproductMultiImages.setPath(imagePath);

			String name = imagePath.substring(imagePath.lastIndexOf("/") + 1);

			oldproductMultiImages.setProductImageName(name.substring(name.indexOf("_") + 1));
			oldproductMultiImages.setImageType(imagePath.substring(imagePath.lastIndexOf(".") + 1));
			productMultiImagesRepository.saveAndFlush(oldproductMultiImages);

		} catch (Exception e) {
			logger.error("uploadImageDetail in ProductMultiImagesServiceImpl---", e);
		}
		return oldproductMultiImages;
	}

}
