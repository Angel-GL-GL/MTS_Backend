package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Lines;
import com.services.api.mts_slt.models.TransportHelper;
import com.services.api.mts_slt.services.Lines_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Lines_Controllers {
    @Autowired
    private Lines_Service service;

    @RequestMapping(value = "api/lines", method = RequestMethod.GET)
    private ResponseEntity<List<Lines>> getAllLines(){
        return ResponseEntity.ok(service.getAllLines());
    }

    @RequestMapping(value = "api/lines/{line}", method = RequestMethod.GET)
    private ResponseEntity<Lines> getLine(@PathVariable Integer line){
        return ResponseEntity.ok(service.getLine(line));
    }

    @RequestMapping(value = "api/transports/lines", method = RequestMethod.GET)
    private ResponseEntity<List<Lines>> getLinesByTransport(@RequestBody TransportHelper transport){
        return ResponseEntity.ok(service.getAllLinesByTransport(transport.getName()));
    }

    @RequestMapping(value = "api/lines/incidents/{in}", method = RequestMethod.GET)
    private ResponseEntity<List<Lines>> getLinesByIncident(@PathVariable String in){
        return ResponseEntity.ok(service.getAllLinesByIncident(in));
    }

    @RequestMapping(value = "api/lines/speeds", method = RequestMethod.GET)
    private ResponseEntity<List<Lines>> getLinesBySpeed(){
        return ResponseEntity.ok(service.getAllLinesBySpeed());
    }

    @RequestMapping(value = "api/lines/update/incident", method = RequestMethod.PUT)
    private boolean updateIncident(@RequestBody Lines line){
        Lines res = service.getLine(line.getId());
        if(!line.getId().equals(res.getId())) return false;
        res.setIncident(line.getIncident());
        res.setSpeed(line.getSpeed());
        service.updateIncident(res);
        return true;
    }
}
