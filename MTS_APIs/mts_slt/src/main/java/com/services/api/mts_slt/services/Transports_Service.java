package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Transports;
import com.services.api.mts_slt.repositories.Transports_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Transports_Service {
    @Autowired
    private Transports_Repository repository;
    //Obtener transportes
    public List<Transports> getAllTransports(){return repository.findAll();}
    //Obtener transporte
    public Transports getTransport(String name){
        Optional<Transports> os = repository.findById(name);
        return os.orElseGet(Transports::new);
    }
}
