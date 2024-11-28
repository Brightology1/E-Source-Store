package org.brightology.esourcestore.controller;

import org.brightology.esourcestore.model.EProduct;
import org.brightology.esourcestore.service.EProductService;
import org.brightology.esourcestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EProductController {

    @Autowired
    private EProductService eservice;
    @Autowired
    private ProductService productService;

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

    @PutMapping("/eproduct/{id}")
    public ResponseEntity<String> updateEProduct(@PathVariable int id, @RequestPart EProduct eprod,
                                                  @RequestPart MultipartFile imageFile) {
        EProduct eprod1 = null;
        try {
            eprod1 = eservice.updateEProduct(id, eprod, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (eprod1 != null)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Update Failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eproduct/{id}")
    public ResponseEntity<String> deleteEProduct(@PathVariable int id) {
        EProduct eprod2 = eservice.getEProductById(id);
        if(eprod2 != null) {
            eservice.deleteEProduct(id);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/eproduct/search")
    public ResponseEntity<List<EProduct>> searchEProduct(String keyword){
        List<EProduct> eprods = eservice.searchEProduct(keyword);
        return new ResponseEntity<>(eprods, HttpStatus.OK);
    }
}
