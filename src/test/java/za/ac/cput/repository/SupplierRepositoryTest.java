package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SupplierFactoryTest.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 25 March 2026
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SupplierRepositoryTest {

    private static ISupplierRepository Repository = SupplierRepository.getRepository();
    private static Supplier supplier = SupplierFactory.createSupplier("SU01A", "Magnolia Supplies", "Magnolia@gmail.com", "0217436798", "Cape Town");

    @Test
    @Order(1)
    public void testCreate() {
        Supplier created = Repository.create(supplier);
        Assertions.assertNotNull(created);
        Assertions.assertEquals(supplier.getSupplierId(), created.getSupplierId());
    }

    @Test
    @Order(2)
    public void testFindById() {
        Supplier found = Repository.findbyId(supplier.getSupplierId());
        assertNotNull(found);
        assertEquals(supplier.getSupplierId(), found.getSupplierId());
    }

    @Test
    @Order(3)
    public void testFindAll() {
        assertFalse(Repository.findall().isEmpty(), "There are no Suppliers");
        assertNotNull(Repository.findall(), "The list of Suppliers is null");

    }

    @Test
    @Order(4)
    public void update() {
        Supplier update = new Supplier.Builder()
                .setSupplierId("SU01A")
                .setSupplierName("Updated Name")
                .setSupplierEmail("Magnolia@gmail.com")
                .setPhoneNumber("0217436798")
                .setSupplierAddress("Cape Town")
                .build();

    }

    @Test
    @Order(5)
    public void delete() {
        Repository.delete(supplier.getSupplierId());
        Supplier deleted = Repository.findbyId(supplier.getSupplierId());
        assertNull(deleted);
    }


}//





























/*package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SupplierFactoryTest.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 25 March 2026

class SupplierRepositoryTest {

    private SupplierRepository repository;
    private Supplier supplier;

    @BeforeEach
    void setUp() {
        repository = SupplierRepository.getRepository();

        supplier = new Supplier.Builder()
                .setSupplierId("S001")
                .setSupplierName("ABC Supplies")
                .setSupplierEmail("abc@gmail.com")
                .setPhoneNumber("0123456789")
                .setSupplierAddress("Cape Town")
                .build();

        repository.save(supplier);
    }

    @Test
    void save() {
        Supplier newSupplier = new Supplier.Builder()
                .setSupplierId("S002")
                .setSupplierName("XYZ Supplies")
                .build();

        Supplier saved = repository.save(newSupplier);

        assertNotNull(saved);
        assertEquals("S002", saved.getSupplierId());
    }

    @Test
    void findById() {
        Supplier found = repository.findbyId("S001");

        assertNotNull(found);
        assertEquals("ABC Supplies", found.getSupplierName());
    }

    @Test
    void findAll() {
        List<Supplier> suppliers = repository.findall();

        assertTrue(suppliers.size() >= 1);
    }

    @Test
    void update() {
        Supplier updated = new Supplier.Builder()
                .setSupplierId("S001")
                .setSupplierName("Updated Name")
                .build();

        Supplier result = repository.update(updated);

        assertNotNull(result);
        assertEquals("Updated Name", result.getSupplierName());
    }

    @Test
    void delete() {
        repository.delete("S001");

        Supplier deleted = repository.findbyId("S001");

        assertNull(deleted);
    }
}*/
