package com.jewellery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewellery.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByIsActive(int zero);

}
