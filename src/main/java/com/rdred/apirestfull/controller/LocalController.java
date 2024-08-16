package com.rdred.apirestfull.controller;

import com.rdred.apirestfull.entity.Local;
import com.rdred.apirestfull.service.LocalService;
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

    @GetMapping("/findLocalbyid")
    Optional<Local> findByNAmejpl(@PathVariable String name){return localService.findLocalNameWithJpql(name);}

    @PostMapping("/savelocal")
    public Local savedLocal(@RequestBody Local local){return localService.saveLocal(local);}

    @PutMapping("/updatelocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local ){return localService.updateLocal(id, local);}

    @DeleteMapping("/deletlocal/{id}")
    public String deletLocal(@PathVariable Long id){
        localService.deletLocal(id);
        return "Area local eliminado correctamente";
    }
}