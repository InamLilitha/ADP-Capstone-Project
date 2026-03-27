package za.ac.cput.domain;

/**
 * CustomerOrder
 * Order model class
 * Order Builder
 * Ryan Paledi 230969429
 */

public class CustomerOrder {

    private String orderId;
    private String orderDate;
    private String orderStatus;
    private double totalAmount;
    private String customerId;

    private CustomerOrder(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.orderStatus = builder.orderStatus;
        this.totalAmount = builder.totalAmount;
        this.customerId = builder.customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public static class Builder {

        private String orderId;
        private String orderDate;
        private String orderStatus;
        private double totalAmount;
        private String customerId;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public CustomerOrder build() {
            return new CustomerOrder(this);
        }
    }
}