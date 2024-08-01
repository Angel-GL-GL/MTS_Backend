package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Stations;
import com.services.api.mts_slt.repositories.Stations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Stations_Service {
    @Autowired
    private Stations_Repository repository;

    public List<Stations> getAllStations(){return repository.findAll();}

    public Stations getStation(Integer id){
        Optional<Stations> os = repository.findById(id);
        return os.orElseGet(Stations::new);
    }

    public Stations getStation(String name, Integer line){
        return repository.findByNameAndLine(name,line);
    }

    public List<Stations> getAllStationsByLine(Integer line){
        List<Stations> res = repository.findByLine(line);
        if(!res.isEmpty()) return res;
        return new ArrayList<>();
    }

    public List<Stations> getAllStationsByIncident(String incident){
        List<Stations> res = repository.findByIncident(incident);
        if(!res.isEmpty()) return res;
        return new ArrayList<>();
    }
}
