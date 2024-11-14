package org.brightology.esourcestore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    
    private int pID;
    private String pName;
    private int pPrice;
    private double pAge;
}
