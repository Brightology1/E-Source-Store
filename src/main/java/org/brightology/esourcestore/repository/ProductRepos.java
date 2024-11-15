package org.brightology.esourcestore.repository;

import org.brightology.esourcestore.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepos extends JpaRepository<Products, Integer> {
}
