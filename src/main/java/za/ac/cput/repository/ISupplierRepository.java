package za.ac.cput.repository;

import za.ac.cput.domain.Supplier;
import java.util.*;

/**
 * ISupplierRepository.java
 * Author: Inam Ngqokomashe
 * 222660155
 *Date: 22 March 2026
 */
public interface ISupplierRepository {
    Supplier create(Supplier supplier);
    Supplier findbyId(String supplierId);
    List<Supplier> findall();
    Supplier update(Supplier supplier);
    void delete(String supplierId);
}
