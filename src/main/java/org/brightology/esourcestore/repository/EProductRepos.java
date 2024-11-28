package org.brightology.esourcestore.repository;

import org.brightology.esourcestore.model.EProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EProductRepos extends JpaRepository<EProduct, Integer> {

    @Query("SELECT e from EProduct e WHERE "+
    "LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    "LOWER(e.desc) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
     "LOWER(e.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
     "LOWER(e.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<EProduct> searchEProduct (String keyword);
}
