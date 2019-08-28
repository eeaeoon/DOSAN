package com.example.dosan.repository;

import com.example.dosan.model.ProductBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, String> {

}