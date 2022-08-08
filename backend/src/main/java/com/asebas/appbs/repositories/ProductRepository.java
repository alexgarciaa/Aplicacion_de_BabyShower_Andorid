package com.asebas.appbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asebas.appbs.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByCodigo(String codigo);
}
