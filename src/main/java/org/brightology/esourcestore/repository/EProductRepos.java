package org.brightology.esourcestore.repository;

import org.brightology.esourcestore.model.EProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EProductRepos extends JpaRepository<EProduct, Integer> {
}
