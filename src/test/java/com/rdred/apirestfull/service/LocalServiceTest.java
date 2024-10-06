package com.rdred.apirestfull.service;

import com.rdred.apirestfull.entity.Local;
import com.rdred.apirestfull.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalServiceTest {

    @Autowired
    private LocalService localService;
    @MockBean
    private LocalRepository localRepository;

    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                .id(1L)
                .name("Petshop")
                .piso("Segundo piso")
                .code("StreUd34")
                .build();
        Mockito.when(localRepository.findByNameIgnoreCase("Petshop")).thenReturn(Optional.of(local));
    }

    @Test
    @DisplayName("Prueva de persitencia en informacio local enviando un valor") // Para añadir etiqueta
    public void findByNameIgnoreCaseShouldFound(){
        String localName = "Petshop";
        Local local = localService.findByNameIgnoreCase(localName).get();
        assertEquals(localName, local.getName());
        System.out.println("local = " + local);
    }
}