package za.ac.cput.domain;

/**
 * Supplier.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 09 March 2026
 */

public class Supplier {

    private String supplierId;
    private String supplierName;
    private String supplierEmail;
    private String phoneNumber;
    private String supplierAddress;

    public Supplier(Builder builder) {
        this.supplierId = builder.supplierId;
        this.supplierName = builder.supplierName;
        this.supplierEmail = builder.supplierEmail;
        this.phoneNumber = builder.phoneNumber;
        this.supplierAddress = builder.supplierAddress;

    }

    public String getSupplierId() {

        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {

        return supplierEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSupplierAddress() {

        return supplierAddress;
    }



    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                '}';
    }

    public static class Builder {
        private String supplierId;
        private String supplierName;
        private String supplierEmail;
        private String phoneNumber;
        private String supplierAddress;


        public Builder setSupplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }
        public Builder setSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }
        public Builder setSupplierEmail(String supplierEmail) {
            this.supplierEmail = supplierEmail;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder setSupplierAddress(String supplierAddress) {
            this.supplierAddress = supplierAddress;
            return this;
        }
        public Supplier build() {

            return new Supplier(this);
        }


    }
}

