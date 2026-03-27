/*
 *ProductRepository.java
 *Maghdie Petersen 230600204
 *  */
package za.ac.cput.repository;

import za.ac.cput.domain.ProductDomain;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static IProductRepository repository = null;
    private List<ProductDomain> productList;

    private ProductRepository(){
        productList = new ArrayList<>();
    }

    public static IProductRepository getRepository(){
        if (repository == null){
            repository = new ProductRepository();
        }
        return repository;
    }

    @Override
    public ProductDomain create(ProductDomain product) {
        boolean success = productList.add(product);
        return success ? product : null;
    }

    @Override
    public ProductDomain read(String id) {
        return productList.stream()
                .filter(p -> p.getProductId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public ProductDomain update(ProductDomain product) {
        ProductDomain oldProduct = read(product.getProductId());
        if(oldProduct != null){
            productList.remove(oldProduct);
            productList.add(product);
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        ProductDomain productToDelete = read(id);
        return productToDelete != null && productList.remove(productToDelete);
    }

    @Override
    public List<ProductDomain> getAll() {
        return productList;
    }
}

