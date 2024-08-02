package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.RSMs;
import com.services.api.mts_slt.repositories.RSMs_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class RSMs_Service {
    @Autowired
    private RSMs_Repository repository;
    //Todos los match
    public List<RSMs> getAllRSMs(){return repository.findAll();};
    //Todos los match por ruta
    public List<RSMs> getAllRSMsByRoute(Integer route){
        List<RSMs> res = repository.findByRoute(route);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }
    //Todos los match por estación
    public List<RSMs> getAllRSMsByStation(Integer station){
        List<RSMs> res = repository.findByStation(station);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }
}
