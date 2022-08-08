package com.asebas.appbs.services;

import java.util.List;

import com.asebas.appbs.domain.Product;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Integer id) throws CResourceNotFoundException;

    Product getProductByCode(String codigo) throws CResourceNotFoundException;

    Product addProduct(String descripcion, String codigo, String imagen, Double precio, Double precioBs)
            throws CBadRequestException;

    void updateProduct(Integer id, Product product) throws CBadRequestException;

    void deleteProduct(Integer id) throws CResourceNotFoundException;

}
