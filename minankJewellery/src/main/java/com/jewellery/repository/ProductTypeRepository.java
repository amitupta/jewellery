package com.jewellery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewellery.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

	List<ProductType> findByIsActive(int zero);

}
