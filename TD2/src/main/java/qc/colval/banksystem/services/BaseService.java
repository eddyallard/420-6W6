package qc.colval.banksystem.services;

import java.util.List;
import java.util.Optional;

/**
 * This interface provides a Base model for all interfaces, with the most basic CRUD Implementations
 * */
public interface BaseService<E> {
    E create(E entity);
    Optional<E> findOne(Integer id);
    List<E> findAll();
    void delete(Integer id);
}
