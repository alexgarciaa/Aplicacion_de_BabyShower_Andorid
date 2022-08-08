package com.asebas.appbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asebas.appbs.domain.Product;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) throws CResourceNotFoundException {
        try {
            return productRepository.findById(id).get();
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public Product getProductByCode(String codigo) throws CResourceNotFoundException {
        try {
            return productRepository.findByCodigo(codigo);
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public Product addProduct(String descripcion, String codigo, String imagen, Double precio, Double precioBs)
            throws CBadRequestException {
        try {
            Product product = new Product(descripcion, codigo, imagen, precio, precioBs);
    
            return productRepository.save(product);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to create");
        }
    }

    @Override
    public void updateProduct(Integer id, Product product) throws CBadRequestException {
        try {
            Product existingProduct = productRepository.findById(id).get();
    
            existingProduct.setDescripcion(product.getDescripcion());
            existingProduct.setCodigo(product.getCodigo());
            existingProduct.setImagen(product.getImagen());
            existingProduct.setPrecio(product.getPrecio());
            existingProduct.setPrecioBs(product.getPrecioBs());
    
            productRepository.save(existingProduct);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

    @Override
    public void deleteProduct(Integer id) throws CResourceNotFoundException {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

}
