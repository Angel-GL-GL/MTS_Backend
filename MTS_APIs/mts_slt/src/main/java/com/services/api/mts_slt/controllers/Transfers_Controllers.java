package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.RSMs;
import com.services.api.mts_slt.models.Transfers;
import com.services.api.mts_slt.models.Stations;
import com.services.api.mts_slt.services.RSMs_Service;
import com.services.api.mts_slt.services.Transfers_Service;
import com.services.api.mts_slt.services.Stations_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Transfers_Controllers {
    @Autowired
    private Transfers_Service service;
    @Autowired
    private Stations_Service stations_service;
    @Autowired
    private RSMs_Service rsms_service;

    @RequestMapping(value = "api/stations/{station}/transfers", method = RequestMethod.GET)
    private ResponseEntity<List<Stations>> getTransfersStation(@PathVariable Integer station){
        List<Transfers> transfers = service.getAllTransfersByStation(station);

        if(transfers.isEmpty()) return ResponseEntity.ok(new ArrayList<>());

        ArrayList<Stations> stations = new ArrayList<>(transfers.size());

        for (Transfers transfer : transfers) {
            //El id enviado es igual al id de la estación A del transborde? Entonces agrega la estación con el id de B
            if(station.equals(transfer.getA()))
                stations.add(stations_service.getStation(transfer.getB()));
            //El id enviado es igual al id de la estación B del transborde? Entonces agrega la estación con el id de A
            else if(station.equals(transfer.getB()))
                stations.add(stations_service.getStation(transfer.getA()));
        }
        return ResponseEntity.ok(stations);
    }

    @RequestMapping(value = "api/routes/{route}/transfers", method = RequestMethod.GET)
    private ResponseEntity<List<Stations>> getTransfersRoute(@PathVariable Integer route){
        List<RSMs> rsms = rsms_service.getAllRSMsByRoute(route);

        if(rsms.isEmpty()) return ResponseEntity.ok(new ArrayList<>());

        ArrayList<Stations> stations = new ArrayList<>();

        for(RSMs rsm: rsms){
            Stations station = stations_service.getStation(rsm.getStation());
            if(service.hasTransfer(station.getId())) stations.add(station);
        }

        return ResponseEntity.ok(stations);
    }
}
