package com.rdred.apirestfull.service;

import com.rdred.apirestfull.entity.Local;
import com.rdred.apirestfull.error.LocalNotFoundException;
import com.rdred.apirestfull.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImplmetion implements LocalService{
    @Autowired
    LocalRepository localRepository;


    @Override
    public Local findLocalByid(Long id) throws LocalNotFoundException {
        Optional<Local> local = localRepository.findById(id);
        if (!local.isPresent())
            throw new LocalNotFoundException("Local no esta disponible");
        return local.get();
    }

    @Override
    public List<Local> findAllLocals() {
        //Traer todo los datos de tabla
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local){
        Local localDb = localRepository.findById(id).get();
        // Validaciond de datos
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())){
            localDb.setCode(local.getCode());
        }if (Objects.nonNull(local.getPiso()) && !"".equalsIgnoreCase(local.getPiso())) {
            localDb.setPiso(local.getPiso());
        }if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())){
            localDb.setName(local.getName());
        }
        // Actulizacion
        return localRepository.save(localDb);
    }

    @Override
    public void deletLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<Local> findLocalNameWithJpql(String name) {
        return localRepository.findLocalNameWithJpql(name);
    }

    @Override
    public Optional<Local> findByName(String name) {
        return localRepository.findByName(name);
    }

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
    }
}
