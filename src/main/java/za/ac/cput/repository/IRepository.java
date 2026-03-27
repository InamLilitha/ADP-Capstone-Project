/*
 *IRepository.java
 *Generic Repository Interface
 *Maghdie Petersen 230600204
 *  */
package za.ac.cput.repository;

public interface IRepository<T , ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
