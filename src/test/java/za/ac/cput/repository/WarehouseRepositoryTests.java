package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Warehouse;
import za.ac.cput.factory.WarehouseFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WarehouseRepositoryTests.java
 * Warehouse Repository Tests
 * Author: Tebogo Pii (230226442)
 * Date: 24 March 2026
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WarehouseRepositoryTests {

    private static IWarehouseRepository repository = WarehouseRepository.getRepository();
    private static Warehouse warehouse = WarehouseFactory.buildWarehouse("WH-001", "Cape Town", 5000);

    @Test
    @Order(1)
    void testCreate() {
        Warehouse created = repository.create(warehouse);
        assertNotNull(created, "Repository failed to create the warehouse.");
        assertEquals("WH-001", created.getWarehouseId(), "Warehouse ID does not match.");
    }

    @Test
    @Order(2)
    void testRead() {
        Warehouse read = repository.read("WH-001");
        assertNotNull(read, "Repository failed to read the warehouse by ID.");
        assertEquals("Cape Town", read.getLocation(), "Warehouse location does not match.");
    }

    @Test
    @Order(3)
    void testUpdate() {
        Warehouse updated = new Warehouse.Builder()
                .copy(warehouse)
                .setLocation("Pretoria")
                .setCapacity(8500)
                .build();
        Warehouse result = repository.update(updated);
        assertNotNull(result, "Repository failed to update the warehouse.");
        assertEquals("Pretoria", repository.read("WH-001").getLocation(), "Location was not updated correctly.");
    }

    @Test
    @Order(4)
    void testGetAll() {
        assertNotNull(repository.getAll(), "Warehouse set should not be null.");
        assertFalse(repository.getAll().isEmpty(), "Warehouse set should contain at least one entry.");
    }

    @Test
    @Order(5)
    void testDelete() {
        boolean deleted = repository.delete("WH-001");
        assertTrue(deleted, "Repository failed to delete the warehouse.");
        assertNull(repository.read("WH-001"), "Warehouse should no longer exist after deletion.");
    }

    @Test
    @Order(6)
    void testFactoryRejectsNullId() {
        Warehouse invalid = WarehouseFactory.buildWarehouse(null, "Durban", 3000);
        assertNull(invalid, "Factory should return null when warehouse ID is null.");
    }

    @Test
    @Order(7)
    void testFactoryRejectsNegativeCapacity() {
        Warehouse invalid = WarehouseFactory.buildWarehouse("WH-002", "Durban", -100);
        assertNull(invalid, "Factory should return null when capacity is negative.");
    }

    @Test
    @Order(8)
    void testFactoryRejectsEmptyLocation() {
        Warehouse invalid = WarehouseFactory.buildWarehouse("WH-003", "", 2000);
        assertNull(invalid, "Factory should return null when location is empty.");
    }
}