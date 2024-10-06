package com.rdred.apirestfull.controller;

import com.rdred.apirestfull.entity.Local;
import com.rdred.apirestfull.error.LocalNotFoundException;
import com.rdred.apirestfull.service.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController

public class LocalController{

    @Autowired
    LocalService localService;

    @GetMapping("/findall")
    public List<Local> findAllLocal(){return localService.findAllLocals();}

    // Consulta 1 por nombre
    @GetMapping("/findlocalbyid/{name}")
    Optional<Local> findByNAmejpl(@PathVariable String name){return localService.findLocalNameWithJpql(name);}
    // Consulta 2 por nombre
    @GetMapping("/consultaLocal/{name}")
    Optional <Local> consultaLocalNombre(@PathVariable String name){return localService.findByName(name);}
    // Consulta 3 por nombre Ignorando el caso de mayusculas
    @GetMapping("/consultaLocals/{name}")
    Optional <Local> consultaLocalNombreCase(@PathVariable String name){return localService.findByNameIgnoreCase(name);}


    // Consulta 4 por id Con exetpciones  /consultaLocalid/{id}
    @GetMapping("/consultaLocalid/{id}")
    Local consultaLocalIdException(@PathVariable Long id) throws LocalNotFoundException {return localService.findLocalByid(id);}

    @PostMapping("/savelocal")
    public Local savedLocal(@Valid @RequestBody Local local){return localService.saveLocal(local);}

    @PutMapping("/updatelocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local ){return localService.updateLocal(id, local);}

    @DeleteMapping("/deletlocal/{id}")
    public String deletLocal(@PathVariable Long id){
        localService.deletLocal(id);
        return "Area local eliminado correctamente";
    }
}