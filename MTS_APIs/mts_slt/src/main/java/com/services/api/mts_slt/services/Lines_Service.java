package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Lines;
import com.services.api.mts_slt.repositories.Lines_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Lines_Service {
    @Autowired
    private Lines_Repository repository;

    public List<Lines> getAllLines(){return repository.findAll();}

    public Lines getLine(Integer id){
        Optional<Lines> os = repository.findById(id);
        return os.orElseGet(Lines::new);
    }

    public Lines getLine(String name, String transport){
        return repository.findByNameAndTransport(name,transport);
    }

    public List<Lines> getAllLinesByTransport(String transport){
        List<Lines> res = repository.findByTransport(transport);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }

    public List<Lines> getAllLinesByIncident(String incident){
        List<Lines> res = repository.findByIncident(incident);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }

    public List<Lines> getAllLinesBySpeed(BigDecimal speed){
        List<Lines> res = repository.findBySpeed(speed);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }
}
