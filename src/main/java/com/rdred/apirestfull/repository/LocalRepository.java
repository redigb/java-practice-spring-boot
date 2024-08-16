package com.rdred.apirestfull.repository;

import com.rdred.apirestfull.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// Capa de acceso a datos
public interface LocalRepository extends JpaRepository<Local, Long>{

    // Consultas Gustomizadas o personalizadas
    //@Query("SELECT l FROM locals l WHERE l.local = :name")
    //Optional<Local> findLocalNameWithJpql(String name);

    // Consultas personalizadas
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalNameWithJpql(String name);
}
