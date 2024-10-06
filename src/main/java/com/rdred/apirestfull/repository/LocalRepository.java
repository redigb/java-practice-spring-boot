package com.rdred.apirestfull.repository;

import com.rdred.apirestfull.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// Capa de acceso a datos
public interface LocalRepository extends JpaRepository<Local, Long>{

    // Consultas personalizadas(SOLO SQL)
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalNameWithJpql(String name);

    // Modo consulta jpa - spring-(Inversion de control)
    Optional<Local> findByName(String name);
    // Ignora las excepciones de los valores
    Optional<Local> findByNameIgnoreCase(String name);
}
