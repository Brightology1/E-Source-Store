package org.brightology.esourcestore.service;

import org.brightology.esourcestore.model.EProduct;
import org.brightology.esourcestore.repository.EProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EProductService {

    @Autowired
    private EProductRepos erepos;

    public List<EProduct> getAllProducts() {
        return erepos.findAll();
    }

    public EProduct getEProductById(int id){
        return erepos.findById(id).orElse(null);
    }

    public EProduct addEProduct(EProduct eprod, MultipartFile imageFile) throws IOException {
        eprod.setImageName(imageFile.getOriginalFilename());
        eprod.setImageType(imageFile.getContentType());
        eprod.setImageDate(imageFile.getBytes());
        return erepos.save(eprod);
    }

    public EProduct updateEProduct(int id, EProduct eprod, MultipartFile imageFile) throws IOException {
        eprod.setImageDate(imageFile.getBytes());
        eprod.setImageName(imageFile.getOriginalFilename());
        eprod.setImageType(imageFile.getContentType());
        return erepos.save(eprod);
    }

    public void deleteEProduct(int id) {
        erepos.deleteById(id);
    }

    public List<EProduct> searchEProduct(String keyword) {
        return erepos.searchEProduct(keyword);
    }
}
