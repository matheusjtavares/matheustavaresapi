package br.edu.infnet.matheustavaresapi.model.service;

import java.util.List;

public interface CrudService<T,ID> {

    T save(T entity);
    T getById(ID id);
    void delete(ID id);
    List<T> getList();
}
