package org.brightology.esourcestore.service;

import org.brightology.esourcestore.model.EProduct;
import org.brightology.esourcestore.repository.EProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
