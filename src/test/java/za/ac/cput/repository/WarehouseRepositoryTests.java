package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Customer;
import static org.junit.jupiter.api.Assertions.*;

/**
 * WarehouseRepositoryTests.java
 * Warehouse tests
 * Author: Tebogo Pii (230226442)
 * Date: 23 March 2026
 */

public class WarehouseRepositoryTests {
    @Test
    void requireNotNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer("", "tee@gmail.com", 20);
        }, "Should throw exception for empty name");
    }

    @Test
    void requireNotNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer("Tee", "tee@gmail.com", -5);
        }, "Should throw exception for negative age");
    }

    @Test
    void requireNotOver25Characters() {
        String longName = "IMJustTypingToMakeALongNameLikeThis";
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer(longName, "tee@gmail.com", 20);
        }, "Should throw exception for name over 25 characters");
    }

    @Test
    void doesEmailContainSpecialCharacters() {
        Customer customer = CustomerFactory.createCustomer("Tee", "tee@gmail.com", 20);
        assertNotNull(customer);
        assertTrue(customer.getEmail().contains("@"), "Email should contain @");
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer("Tebogo", "23tebogogmail.com", 20);
        }, "Should throw exception for invalid email format");
    }

    @Test
    void ageIsLessThan18() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer("Tee", "tee@gmail.com", 16);
        }, "Should throw exception for age less than 18");
    }

    @Test
    void emailNotOver25Characters() {
        String longEmail = "thisemailiswaytoolongtobevalid@gmail.com";
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer("Tee", longEmail, 20);
        }, "Should throw exception for email over 25 characters");
    }
}