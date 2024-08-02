package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Stations;
import com.services.api.mts_slt.services.Stations_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Stations_Controllers {
    @Autowired
    private Stations_Service service;

    @RequestMapping(value = "api/stations", method = RequestMethod.GET)
    private ResponseEntity<List<Stations>> getAllStations(){
        return ResponseEntity.ok(service.getAllStations());
    }

    @RequestMapping(value = "api/stations/{station}", method = RequestMethod.GET)
    private ResponseEntity<Stations> getStation(@PathVariable Integer station){
        return ResponseEntity.ok(service.getStation(station));
    }

    @RequestMapping(value = "api/lines/{line}/stations", method = RequestMethod.GET)
    private ResponseEntity<List<Stations>> getStationsByLine(@PathVariable Integer line){
        return ResponseEntity.ok(service.getAllStationsByLine(line));
    }

    @RequestMapping(value = "api/stations/incidents/{in}", method = RequestMethod.GET)
    private ResponseEntity<List<Stations>> getLinesByIncident(@PathVariable String in){
        return ResponseEntity.ok(service.getAllStationsByIncident(in));
    }

    @RequestMapping(value = "api/stations/update/incident", method = RequestMethod.PUT)
    private boolean updateIncident(@RequestBody Stations stations){
        Stations res = service.getStation(stations.getId());
        if(!stations.getId().equals(res.getId())) return false;
        res.setIncident(stations.getIncident());
        service.updateIncident(res);
        return true;
    }
}
