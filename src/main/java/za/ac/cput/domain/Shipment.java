package za.ac.cput.domain;

/**
 * Shipment
 * Shipment model class
 * Shipment Builder
 * Simphiwe 221549323
 */

import java.time.LocalDate;

public class Shipment {

    private final String shipmentId;
    private final String orderId;
    private final LocalDate shipmentDate;
    private final LocalDate deliveryDate;
    private final String status;
    private final String carrier;


    private Shipment(Builder builder) {
        this.shipmentId = builder.shipmentId;
        this.orderId = builder.orderId;
        this.shipmentDate = builder.shipmentDate;
        this.deliveryDate = builder.deliveryDate;
        this.status = builder.status;
        this.carrier = builder.carrier;
    }


    public String getShipmentId() {
        return shipmentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public String getCarrier() {
        return carrier;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", shipmentDate=" + shipmentDate +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }


    public static class Builder {
        private String shipmentId;
        private String orderId;
        private LocalDate shipmentDate;
        private LocalDate deliveryDate;
        private String status;
        private String carrier;

        public Builder setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setShipmentDate(LocalDate shipmentDate) {
            this.shipmentDate = shipmentDate;
            return this;
        }

        public Builder setDeliveryDate(LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCarrier(String carrier) {
            this.carrier = carrier;
            return this;
        }


        public Shipment build() {
            return new Shipment(this);
        }
    }


}


