package za.ac.cput.factory;

import za.ac.cput.domain.Shipment;

import java.time.LocalDate;

public class ShipmentFactory {


    public static Shipment createShipment(String shipmentId, String orderId, LocalDate shipmentDate,
                                          LocalDate deliveryDate, String status, String carrier) {
        return new Shipment.Builder()
                .setShipmentId(shipmentId)
                .setOrderId(orderId)
                .setShipmentDate(shipmentDate)
                .setDeliveryDate(deliveryDate)
                .setStatus(status)
                .setCarrier(carrier)
                .build();
    }
}


