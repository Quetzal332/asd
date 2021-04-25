package com.daniil.spbt.controllers;

import com.daniil.spbt.entities.Product;
import com.daniil.spbt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/products")
public class MainContrl {

    ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    String get(Model model){
        Product product = new Product();
        model.addAttribute("products",productService.all());
        model.addAttribute("product",product);
        return "products";
    }


    @PostMapping("/add")
    String post(@ModelAttribute(value = "product") Product product ){
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping(value = "/show/{id}")
    String show(Model model, @PathVariable(value = "id")Long id){
        Product product = productService.ById(id);
        model.addAttribute("product",product);
        return "prod-page";
    }

    @PostMapping("/show/{id}")
    String edit(@ModelAttribute("product") Product product){
        productService.edit(product);
        return "redirect:/products";
    }

    @DeleteMapping("/dell/{id}")

    void del(@PathVariable(value = "id")Long id){
        productService.dell(id);
        
    }

    @GetMapping("/dell/{id}")
    String dell(@PathVariable(value = "id")Long id){
    productService.dell(id);
        return "redirect:/products";
    }
}
