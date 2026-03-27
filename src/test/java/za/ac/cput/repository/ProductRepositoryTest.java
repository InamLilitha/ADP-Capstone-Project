/*
 *ProductRepositoryTest.java
 *Maghdie Petersen 230600204
 *  */

package za.ac.cput.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ProductDomain;
import za.ac.cput.factory.ProductFactory;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {
    private static IProductRepository repository = ProductRepository.getRepository();
    private static ProductDomain product = ProductFactory.createProduct("Industrial Grade Fertilizer", "Agriculture", (double)800.0F, "50Kg Bag");

    @Test
    @Order(1)
    public void testCreate() {
        ProductDomain created = (ProductDomain)repository.create(product);
        Assertions.assertNotNull(created, "Repository failed to create the product.");
        Assertions.assertEquals(product.getProductId(), created.getProductId(), "Created ID should not match input ID.");
    }

    @Test
    @Order(2)
    public void testRead() {
        ProductDomain read = (ProductDomain)repository.read(product.getProductId());
        Assertions.assertNotNull(read, "Repository failed to read the product by ID.");
        Assertions.assertEquals("Agriculture", read.getCategory(), "The category of the read product is incorrect.");
    }

    @Test
    @Order(3)
    public void testUpdate() {
        ProductDomain updatedProduct = (new ProductDomain.Builder()).copy(product).setPrice((double)1900.0F).setDescription("Premium Industrial Fertilizer").build();
        ProductDomain result = (ProductDomain)repository.update(updatedProduct);
        Assertions.assertNotNull(result, "Repository failed to update the product.");
        Assertions.assertEquals((double)1900.0F, ((ProductDomain)repository.read(product.getProductId())).getPrice(), "The price was not updated correctly.");
    }

    @Test
    @Order(4)
    public void testGetAll() {
        Assertions.assertNotNull(repository.getAll(), "The product list should not be null.");
        Assertions.assertFalse(repository.getAll().isEmpty(), "The product list should contain at least one item.");
    }

    @Test
    @Order(5)
    public void testDelete() {
        boolean deleted = repository.delete(product.getProductId());
        Assertions.assertTrue(deleted, "Repository failed to delete the product.");
        ProductDomain result = (ProductDomain)repository.read(product.getProductId());
        Assertions.assertNull(result, "The product should no longer exist in the repository after deletion.");
    }
}

