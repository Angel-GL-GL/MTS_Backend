package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Routes;
import com.services.api.mts_slt.services.Routes_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Routes_Controllers {
    @Autowired
    private Routes_Service service;
    //Rutas
    @RequestMapping(value = "api/routes", method = RequestMethod.GET)
    private ResponseEntity<List<Routes>> getAll(){
        return ResponseEntity.ok(service.getAllRoutes());
    }
    //Ruta
    @RequestMapping(value = "api/routes/{route}", method = RequestMethod.GET)
    private ResponseEntity<Routes> getRouteID(@PathVariable Integer route){
        return ResponseEntity.ok(service.getRoute(route));
    }
    //Rutas por línea
    @RequestMapping(value = "api/lines/{line}/routes", method = RequestMethod.GET)
    private ResponseEntity<List<Routes>> getRoutesLines(@PathVariable Integer line){
        return ResponseEntity.ok(service.getAllRoutesByLine(line));
    }
}
