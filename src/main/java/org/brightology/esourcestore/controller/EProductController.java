package org.brightology.esourcestore.controller;

import org.brightology.esourcestore.model.EProduct;
import org.brightology.esourcestore.service.EProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EProductController {

    @Autowired
    private EProductService eservice;

    @GetMapping("eproducts")
    public ResponseEntity<List<EProduct>> getAllProducts() {
        return new ResponseEntity<>(eservice.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/eproduct/{id}")
    public ResponseEntity<EProduct> getEProductById(@PathVariable int id){
        EProduct eproduct = eservice.getEProductById(id);
        if(eproduct != null)
            return new ResponseEntity<>(eproduct, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
