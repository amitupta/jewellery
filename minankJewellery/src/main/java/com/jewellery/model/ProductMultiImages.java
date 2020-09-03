package com.jewellery.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_multi_images")
public class ProductMultiImages implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "PRODUCT_IMAGE_ID")
		private Integer productImageId;
		
		@Column(name = "PRODUCT_IMAGE_NAME")
		private String productImageName;
		
		@Column(name = "PATH")
		private String path;
		
		@Column(name = "IMAGE_TYPE")
		private String imageType;
		
		
		@Column(name = "CREATION_DATE")
		private Date creationDate =new Date();
		
		@Column(name = "UPDATION_DATE")
		private Date updationDate;
		
		@Column(name = "IS_ACTIVE")
		private Integer isActive=0; //0 means active

		

		public Integer getProductImageId() {
			return productImageId;
		}

		public void setProductImageId(Integer productImageId) {
			this.productImageId = productImageId;
		}

		public String getProductImageName() {
			return productImageName;
		}

		public void setProductImageName(String productImageName) {
			this.productImageName = productImageName;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getImageType() {
			return imageType;
		}

		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public Date getUpdationDate() {
			return updationDate;
		}

		public void setUpdationDate(Date updationDate) {
			this.updationDate = updationDate;
		}

		public Integer getIsActive() {
			return isActive;
		}

		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
		}
		

}
