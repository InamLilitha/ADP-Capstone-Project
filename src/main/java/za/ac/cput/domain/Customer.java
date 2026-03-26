package za.ac.cput.domain;

/*
Author: Siphamandla
Student Number: 240256891
Milestone 1
Entity: Customer
Date: 13 March 2026
*/

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String address;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    public static class Builder {
        private String customerId;
        private String name;
        private String email;
        private String address;

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.name = customer.name;
            this.email = customer.email;
            this.address = customer.address;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
