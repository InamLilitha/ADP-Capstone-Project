/*
 *IProductRepository.java
 *Maghdie Petersen 230600204
 *  */
package za.ac.cput.repository;

import za.ac.cput.domain.ProductDomain;
import java.util.List;

public interface IProductRepository extends IRepository<ProductDomain, String>{
    List<ProductDomain> getAll();
}
