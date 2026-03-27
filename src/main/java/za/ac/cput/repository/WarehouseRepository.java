package za.ac.cput.repository;

import za.ac.cput.domain.Warehouse;
import java.util.*;

/**
 * WarehouseRepository.java
 * Warehouse Repository Class
 * Author: Tebogo Pii (230226442)
 * Date: 24 March 2026
 */

public class WarehouseRepository implements IWarehouseRepository {

    private static WarehouseRepository repository = null;
    private Set<Warehouse> warehouseSet = null;

    private WarehouseRepository() {
        warehouseSet = new HashSet<>();
    }

    public static WarehouseRepository getRepository() {
        if (repository == null) {
            repository = new WarehouseRepository();
        }
        return repository;
    }

    @Override
    public Warehouse create(Warehouse warehouse) {
        boolean success = warehouseSet.add(warehouse);
        if (!success) {
            return null;
        }
        return warehouse;
    }

    @Override
    public Warehouse read(String warehouseId) {
        for (Warehouse w : warehouseSet) {
            if (w.getWarehouseId().equals(warehouseId)) {
                return w;
            }
        }
        return null;
    }

    @Override
    public Warehouse update(Warehouse warehouse) {
        Warehouse oldWarehouse = read(warehouse.getWarehouseId());
        if (oldWarehouse != null) {
            warehouseSet.remove(oldWarehouse);
            warehouseSet.add(warehouse);
            return warehouse;
        }
        return null;
    }

    @Override
    public boolean delete(String warehouseId) {
        Warehouse warehouseToDelete = read(warehouseId);
        if (warehouseToDelete == null) {
            return false;
        }
        warehouseSet.remove(warehouseToDelete);
        return true;
    }

    @Override
    public Set<Warehouse> getAll() {
        return warehouseSet;
    }
}