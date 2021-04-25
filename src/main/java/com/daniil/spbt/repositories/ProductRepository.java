package com.daniil.spbt.repositories;

import com.daniil.spbt.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> products;

    @PostConstruct
    void init(){
        products = new ArrayList<>();
        products.add(new Product(1L,"sam1",123L));
        products.add(new Product(2L,"sam2",1232L));
        products.add(new Product(3L,"sam3",1233L));
        products.add(new Product(4L,"sam4",1234L));
    }
    
    public void addProduct(Product product){

        products.add(product);
    }

    public List<Product> getAllProduct(){
        return products;
    }
    public Product ById(Long id){
        return products.stream().filter(product -> product.getId().equals(id)).findAny().orElse(null);
    }
    public void edit(Product product){
       Product star = ById(product.getId());
        star.setTitle(product.getTitle());
        star.setCoast(product.getCoast());
    }

    public void dell(Long id) {
        products.remove(ById(id));
    }
}
