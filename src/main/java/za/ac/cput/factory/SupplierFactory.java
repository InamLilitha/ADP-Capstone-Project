package za.ac.cput.factory;
import za.ac.cput.domain.Supplier;

/**
 * SupplierFactory.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 19 March 2026
 */
public class SupplierFactory {

    public static Supplier createSupplier(String supplierId, String supplierName, String supplierEmail, String phoneNumber, String supplierAddress) {

        if (supplierId == null || supplierId.isEmpty() ||
                supplierName == null || supplierName.isEmpty() ||
                supplierEmail == null || supplierEmail.isEmpty() ||
                phoneNumber == null || phoneNumber.isEmpty() ||
                supplierAddress == null || supplierAddress.isEmpty()) {
           throw new IllegalArgumentException("All supplier fields must be provided and cannot be empty.");
        }

        return new Supplier.Builder()
                .setSupplierId(supplierId)
                .setSupplierName(supplierName)
                .setSupplierEmail(supplierEmail)
                .setPhoneNumber(phoneNumber)
                .setSupplierAddress(supplierAddress)
                .build();
    }
}
