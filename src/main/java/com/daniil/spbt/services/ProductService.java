package com.daniil.spbt.services;

import com.daniil.spbt.entities.Product;
import com.daniil.spbt.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("productService")
public class ProductService {

    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   public void add(Product product){
        productRepository.addProduct(product);
    }

    public List<Product> all(){
        return productRepository.getAllProduct();
    }

    public Product ById(Long id){
        return productRepository.ById(id);
    }

    public void edit(Product product){
        productRepository.edit(product);
    }

    public void dell(Long id) {
        productRepository.dell(id);
    }
}
