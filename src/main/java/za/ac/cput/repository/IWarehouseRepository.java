package za.ac.cput.repository;
import za.ac.cput.domain.Warehouse;
import java.util.Set;

/**
 * IWarehouseRepository.java
 * Repository interface for Warehouse
 * Author: Tebogo Pii (230226442
 * Date: 23 March 2026
 */
public interface IWarehouseRepository extends IRepository<Warehouse, String> {
    Set<Warehouse> getAll();
}
