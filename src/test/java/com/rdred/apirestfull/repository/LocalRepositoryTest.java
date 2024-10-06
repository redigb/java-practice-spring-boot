package com.rdred.apirestfull.repository;

import com.rdred.apirestfull.entity.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                        .name("Supermarket")
                        .piso("Tercer piso")
                        .code("12345s")
                        .build();
        // Testeo en memoria - para la prueba unitaria
        testEntityManager.persist(local);
    }

    @Test
    public void findLocalByNameIgnoranceCaseFound(){
        Optional <Local> local = localRepository.findByNameIgnoreCase("Supermarket");
        assertEquals(local.get().getName(), "Supermarket");
        System.out.println("local .get(): " + local.get());
    }

    @Test
    public void findLocalByNameIgnoranceNotFound(){
        Optional<Local> local = localRepository.findByNameIgnoreCase("Cinaema");
        assertEquals(local, Optional.empty());
    }
}