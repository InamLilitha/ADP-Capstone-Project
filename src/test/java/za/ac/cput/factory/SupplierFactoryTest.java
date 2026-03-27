package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Supplier;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SupplierFactoryTest.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 25 March 2026
 */

public class SupplierFactoryTest {

    @Test
    @DisplayName("Test creating a valid Supplier")
    public void createValidSupplier() {
        Supplier supplier = SupplierFactory.createSupplier("SU01A", "Magnolia Supplies", "Magnolia@gmail.com", "0217436798", "Cape Town");
        assertEquals("SU01A", supplier.getSupplierId());
        assertEquals("Magnolia Supplies", supplier.getSupplierName());
        assertEquals("Magnolia@gmail.com", supplier.getSupplierEmail());
        assertEquals("0217436798", supplier.getPhoneNumber());
        assertEquals("Cape Town", supplier.getSupplierAddress());

    }

    @Test
    @DisplayName("Throw exception if Id is blank")
    public void shouldThrowExceptionIfIdIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SupplierFactory.createSupplier("", "Magnolia Supplies", "Magnolia@gmail.com", "0217436798", "Cape Town")
        );
    }

    @Test
    @DisplayName("Throw exception if Name is blank")
    public void shouldThrowExceptionIfNameIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SupplierFactory.createSupplier("SU01A", "", "Magnolia@gmail.com","0217436798", "Cape Town")
        );
    }
    @Test
    @DisplayName("Throw exception if Email is blank")
    public void shouldThrowExceptionIfEmailIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SupplierFactory.createSupplier("SU01A", "Magnolia Supplies", "", "0217436798", "Cape Town")
        );
    }

    @Test
    @DisplayName("Throw exception if Email is invalid")
    public void shouldThrowExceptionIfEmailIsInvalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SupplierFactory.createSupplier("SU01A", "Magnolia Supplies", "invalid-email", "0217436798", "Cape Town")
        );
    }
    @Test
    @DisplayName("Throw exception if Phone Number is null")
    public void shouldThrowExceptionIfPhoneNumberIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SupplierFactory.createSupplier("SU01A", "Magnolia Supplies", "Magnolia@gmail.com","", "Cape Town")
        );

    }

    @Test
    @DisplayName("Throw exception if Address is null")
    public void shouldThrowExceptionIfAddressIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SupplierFactory.createSupplier("SU01A", "Magnolia Supplies", "Magnolia@gmail.com","", "Cape Town")
        );
    }


}
