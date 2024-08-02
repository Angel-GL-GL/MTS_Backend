package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Routes;
import com.services.api.mts_slt.repositories.Routes_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Routes_Service {
    @Autowired
    private Routes_Repository repository;
    //Rutas
    public List<Routes> getAllRoutes(){return repository.findAll();}
    //Ruta
    public Routes getRoute(Integer id){
        return repository.findById(id).orElseGet(Routes::new);
    }
    //Rutas por línea
    public List<Routes> getAllRoutesByLine(Integer line){
        List<Routes> res = repository.findByLine(line);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }
}
