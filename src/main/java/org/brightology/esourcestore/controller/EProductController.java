package org.brightology.esourcestore.controller;

import org.brightology.esourcestore.model.EProduct;
import org.brightology.esourcestore.service.EProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/addEProduct")
    public ResponseEntity<?> addEProduct(@RequestPart EProduct eprod,
                                         @RequestPart MultipartFile imageFile){
        try {
            EProduct eprod1 = eservice.addEProduct(eprod, imageFile);
            return new ResponseEntity<>(eprod1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/eproduct/{id}/image")
    public ResponseEntity<byte[]> getImageByEProductId(@PathVariable int id){
        EProduct eprod = eservice.getEProductById(id);
        byte[] imageFile = eprod.getImageDate();
        return ResponseEntity.ok().
                contentType(MediaType.valueOf(eprod.getImageType())).
                body(imageFile);
    }
}
