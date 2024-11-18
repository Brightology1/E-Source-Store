package org.brightology.esourcestore.controller;

import org.brightology.esourcestore.model.EProduct;
import org.brightology.esourcestore.service.EProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EProductController {

    @Autowired
    private EProductService eservice;

    @GetMapping("eproducts")
    public List<EProduct> getAllProducts() {
        return eservice.getAllProducts();
    }
}
