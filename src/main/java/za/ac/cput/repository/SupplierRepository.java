package za.ac.cput.repository;

import za.ac.cput.domain.Supplier;
import java.util.*;

/**
 * SupplierRepository.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 22 March 2026
 */

public class SupplierRepository implements ISupplierRepository {

    private static SupplierRepository repository = null;

    private Map<String, Supplier> supplierMap;
    private SupplierRepository() {
        supplierMap = new HashMap<>();

    }
    public static SupplierRepository getRepository() {
        if (repository == null) {
            repository = new SupplierRepository();
        }
        return repository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        supplierMap.put(supplier.getSupplierId(), supplier);
        return supplier;
    }

    @Override
    public Supplier findbyId(String supplierId) {
        return supplierMap.get(supplierId);
    }

    @Override
    public List<Supplier> findall() {
        return new ArrayList<>(supplierMap.values());
    }

    @Override
    public Supplier update(Supplier supplier) {

        if(supplierMap.containsKey(supplier.getSupplierId())) {
            supplierMap.put(supplier.getSupplierId(), supplier);
            return supplier;
        }
        return null;
    }

    @Override
    public void delete(String supplierId) {
        supplierMap.remove(supplierId);

    }
}
