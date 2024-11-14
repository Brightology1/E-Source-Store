package org.brightology.esourcestore.service;

import org.brightology.esourcestore.model.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

   public List<Products> products = new ArrayList<>(Arrays.asList(
            new Products(1, "TV",5000,0.9),
            new Products(2,"Radio", 3000, 1.0),
            new Products(3,"Radio2", 3500, 1.3),
            new Products(4,"Head Phone", 2000, 0.8),
            new Products(5,"Head Phone2", 1000, 0.6)
    ));
    public List<Products> getProducts() {
        return products;
    }

    public Products getProductsById(int pID) {
        return products.stream()
                .filter(p -> p.getPID() == pID)
                .findFirst().orElse(new Products(0, "Invalid Product", 0, 0.0));
    }

    public void addProducts(Products prods) {
        products.add(prods);
    }

    public void updateProducts(Products prods) {
        int index = 0;
        for(int i=0;i<products.size();i++)
            if(products.get(i).getPID() == prods.getPID())
                index = i;
        products.set(index, prods);
    }

    public void deleteProducts(int pID) {
        int index = 0;
        for(int i=0;i<products.size();i++)
            if(products.get(i).getPID() == pID)
                index = i;
        products.remove(index);
    }
}
