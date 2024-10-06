package com.rdred.apirestfull.controller;

import com.rdred.apirestfull.entity.Local;
import com.rdred.apirestfull.service.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocalController.class)
class LocalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalService localService;

    private Local local;

    @BeforeEach
    void setUp() {
        local = Local.builder()
                .id(1L)
                .name("Ciname")
                .piso("Piso cuatro s")
                .code("Cin-040-4")
                .build();
    }

    @Test
    public  void saveLocal() throws Exception {
        // Creando el objeto esperado
        Local posTlocal = Local.builder()
                .id(1L)
                .name("Cinema") // Asegúrate de que coincida con el JSON
                .piso("Piso cuatro s")
                .code("Cin-040-4")
                .build();

        // Simulación del servicio con Mockito
        Mockito.when(localService.saveLocal(Mockito.any(Local.class))).thenReturn(posTlocal);

        // Realizando la prueba del endpoint /savelocal - > directamnete
        mockMvc.perform(post("/api/savelocal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"Cinema\",\n" +
                                "    \"piso\": \"Piso cuatro s\",\n" +
                                "    \"code\": \"Cin-040-4\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    // Prueba unitaria - en consulta Id
    public void findLocalByid() throws Exception{
        Mockito.when(localService.findLocalByid(1L)).thenReturn(local);
        mockMvc.perform(get("/api/consultaLocalid/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(local.getName()));
    }
}