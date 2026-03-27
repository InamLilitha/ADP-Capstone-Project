package za.ac.cput.factory;

import za.ac.cput.domain.Warehouse;

/**
 * WarehouseFactory.java
 * Factory for Warehouse entity using internal validation
 * Author: Tebogo Pii (Your-Student-Number)
 * Date: 15-16 March 2026
 */
public class WarehouseFactory {

    public static Warehouse buildWarehouse(String warehouseId, String location, int capacity) {
        if (warehouseId == null || warehouseId.isEmpty() ||
                location == null || location.isEmpty()) {
            return null;
        }

        if (capacity <= 0) {
            return null;
        }

        return new Warehouse.Builder()
                .setWarehouseId(warehouseId)
                .setLocation(location)
                .setCapacity(capacity)
                .build();
    }
}