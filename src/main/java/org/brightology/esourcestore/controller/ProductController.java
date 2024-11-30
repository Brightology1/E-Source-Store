package org.brightology.esourcestore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.brightology.esourcestore.model.Products;
import org.brightology.esourcestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService services;

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to the Home Page!!!";
    }

    @GetMapping("/csrf_token")
    public CsrfToken getCrsfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @RequestMapping("/ProductsHome")
    public List<Products> getProducts(){
        return services.getProducts();
    }

//    @RequestMapping("/ProductsHome/{pID}")
//    public Products getProductsById(@PathVariable int pID){
//        return services.getProductsById(pID);
//    }
    @GetMapping("/ProductsHome/{pID}")
    public Products getProductsById(@PathVariable int pID) {
        return services.getProductsById(pID);
    }

    @PostMapping("/AddProducts")
    public void addProducts(@RequestBody Products prods){
        services.addProducts(prods);
    }

    @PutMapping("/UpdateProducts")
    public void updateProducts(@RequestBody Products prods){
        services.updateProducts(prods);
    }

    @DeleteMapping("/DeleteProducts/{pID}")
    public void deleteProducts(@PathVariable int pID){
         services.deleteProducts(pID);
    }

}
