package com.jewellery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewellery.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
