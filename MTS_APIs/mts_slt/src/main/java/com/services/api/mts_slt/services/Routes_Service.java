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

    public List<Routes> getAllRoutes(){return repository.findAll();}

    public Routes getRoute(Integer id){
        return repository.findById(id).orElseGet(Routes::new);
    }

    public List<Routes> getAllRoutesByLine(Integer line){
        List<Routes> res = repository.findByLine(line);
        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }
}
