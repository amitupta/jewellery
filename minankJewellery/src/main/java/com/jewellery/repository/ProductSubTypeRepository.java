package com.jewellery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewellery.model.ProductSubType;

public interface ProductSubTypeRepository extends JpaRepository<ProductSubType, Integer>{

	List<ProductSubType> findByIsActive(int zero);

}
