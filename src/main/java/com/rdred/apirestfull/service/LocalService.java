package com.rdred.apirestfull.service;

import com.rdred.apirestfull.entity.Local;
import com.rdred.apirestfull.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;


// Capa de servicio
public interface LocalService {
    // - Operaciones-(CRUD)
    List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deletLocal(Long id);
    Optional<Local> findLocalNameWithJpql(String name);
    Optional <Local> findByName(String name);
    Optional <Local> findByNameIgnoreCase (String name);
    Local findLocalByid(Long id) throws LocalNotFoundException;
}
