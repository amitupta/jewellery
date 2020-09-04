package com.jewellery.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prodcut_sub_type") 
public class ProductSubType  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_SUB_TYPE_ID")
	private Integer productSubTypeId;
	
	@Column(name = "PRODUCT_SUB_TYPE_NAME")
	private String productSubTypeName;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate = new Date();

	@Column(name = "UPDATION_DATE")
	private Date updationDate;
	
	@Column(name = "IS_ACTIVE")
	private Integer isActive = 0; // zero means active
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_TYPE_ID_FK")
	private ProductType productType;

	public Integer getProductSubTypeId() {
		return productSubTypeId;
	}

	public void setProductSubTypeId(Integer productSubTypeId) {
		this.productSubTypeId = productSubTypeId;
	}

	public String getProductSubTypeName() {
		return productSubTypeName;
	}

	public void setProductSubTypeName(String productSubTypeName) {
		this.productSubTypeName = productSubTypeName;
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

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
}
