/*
 *ProductFactoryTest.java
 *Maghdie Petersen 230600204
 *  */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ProductDomain;

public class ProductFactoryTest {
    @Test
    public void testCreateProductSuccess() {
        ProductDomain product = ProductFactory.createProduct("Industrial Grade Fertilizer", "Agriculture", (double)750.0F, "50Kg Bag");
        Assertions.assertNotNull(product, "Factory failed to create the ProductDomain object with valid input.");
        Assertions.assertNotNull(product.getProductId(), "Factory failed to generate a unique Product ID.");
        Assertions.assertEquals("Agriculture", product.getCategory(), "Product category does not match the expected value.");
    }

    @Test
    public void testCreateProductWithNegativePrice() {
        ProductDomain product = ProductFactory.createProduct("Crate of Oranges", "Food & Beverage", (double)-89.0F, "Crate");
        Assertions.assertNull(product, "Factory should return null when a negative price is provided.");
    }

    @Test
    public void testCreateProductWithEmptyDescription() {
        ProductDomain product = ProductFactory.createProduct("", "Transportation", (double)500.0F, "Liters");
        Assertions.assertNull(product, "Factory should return null when the description is empty.");
    }
}

