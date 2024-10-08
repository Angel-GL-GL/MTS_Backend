package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Stations;
import com.services.api.mts_slt.repositories.Stations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class Stations_Service {
    @Autowired
    private Stations_Repository repository;
    //Estaciones
    public List<Stations> getAllStations(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}
    //Obtiene estación
    public Stations getStation(Integer id){
        Optional<Stations> os = repository.findById(id);
        return os.orElseGet(Stations::new);
    }
    //Estación por nombre y línea
    public Stations getStation(String name, Integer line){
        return repository.findByNameAndLine(name,line);
    }
    //Obtiene estaciones con un nombre
    public List<Stations> getStations(String name){
        List<Stations> res = repository.findByName(name);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Stations::getId));
        return res;
    }
    //Estaciones de una línea
    public List<Stations> getAllStationsByLine(Integer line){
        List<Stations> res = repository.findByLine(line);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Stations::getId));
        return res;
    }

    //Estaciones con un incidente
    public List<Stations> getAllStationsWithIncident(){
        List<Stations> stations = repository.findByIncidentNot("-");
        if(stations.isEmpty()) return new ArrayList<>();
        stations.sort(Comparator.comparing(Stations::getId));
        return stations;
    }

    //Estaciones con un incidente indicado
    public List<Stations> getAllStationsByIncident(String incident){
        List<Stations> res = repository.findByIncident(incident);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Stations::getId));
        return res;
    }
    //Actualizar
    public void updateIncident(Stations stations){
        repository.save(stations);
    }
}
