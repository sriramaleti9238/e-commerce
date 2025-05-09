package com.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActiveTrue();

    List<Product> findByActiveTrueOrderByNameAsc();

    List<Product> findByNameContainingIgnoreCase(String name);
}
