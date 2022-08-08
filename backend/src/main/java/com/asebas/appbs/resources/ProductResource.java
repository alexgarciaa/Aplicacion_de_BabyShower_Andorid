package com.asebas.appbs.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asebas.appbs.domain.Product;
import com.asebas.appbs.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    private ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    private ResponseEntity<Product> getProductByCode(@PathVariable("code") String code) {
        Product product = productService.getProductByCode(code);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Product> addProduct(@RequestBody Map<String, Object> productMap) {
        String descripcion = (String) productMap.get("descripcion");
        String codigo = (String) productMap.get("codigo");
        String imagen = (String) productMap.get("imagen");
        Double precio = (Double) productMap.get("precio");
        Double precioBs = (Double) productMap.get("precioBs");

        Product product = productService.addProduct(descripcion, codigo, imagen, precio, precioBs);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Map<String, Boolean>> updateProduct(@PathVariable("id") Integer id,
            @RequestBody Product product) {
        productService.updateProduct(id, product);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return null;
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Map<String, Boolean>> removeById(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return null;
    }

}
