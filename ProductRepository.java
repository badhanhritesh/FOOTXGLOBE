package com.football.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
