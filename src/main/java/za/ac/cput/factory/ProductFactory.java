/*
 *ProductFactory.java
 *factory Class for ProductDomain
 *Maghdie Petersen 230600204
 *  */
package za.ac.cput.factory;

import za.ac.cput.domain.ProductDomain;
import java.util.UUID;

public class ProductFactory {

    public static ProductDomain createProduct(String description,String category,double price,String unitOfMeasure){
        //Validation Logic
        if (description == null || description.isEmpty() ||
                category == null || category.isEmpty() ||
                unitOfMeasure == null || unitOfMeasure.isEmpty()){
            return null;//Returns null if essential data is missing
        }

        if (price < 0){
            return null;//A product cannot have a negative price
        }

        //Automated ID generation which ensures every product has a unique ID without the user having to type one in
        String productId = UUID.randomUUID().toString();

        //
        return new ProductDomain.Builder()
                .setProductId(productId)
                .setDescription(description)
                .setCategory(category)
                .setPrice(price)
                .setUnitOfMeasure(unitOfMeasure)
                .build();
    }
}

