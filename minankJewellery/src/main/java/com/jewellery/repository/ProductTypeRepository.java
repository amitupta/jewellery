package com.jewellery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewellery.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

}
