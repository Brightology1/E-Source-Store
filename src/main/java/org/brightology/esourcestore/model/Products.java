package org.brightology.esourcestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products {

    @Id
    private int pID;
    private String pName;
    private int pPrice;
    private double pAge;
}
