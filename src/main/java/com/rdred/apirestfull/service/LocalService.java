package com.rdred.apirestfull.service;

import com.rdred.apirestfull.entity.Local;

import java.util.List;
import java.util.Optional;


// Capa de servicio
public interface LocalService {
    // Operaciones-(CRUD)
    List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deletLocal(Long id);
    Optional<Local> findLocalNameWithJpql(String name);
}
