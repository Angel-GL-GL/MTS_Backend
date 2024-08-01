package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Transfers;
import com.services.api.mts_slt.models.Stations;
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
    private Stations_Service helper_service;

    @RequestMapping(value = "api/transfers/{station}", method = RequestMethod.GET)
    private ResponseEntity<List<Stations>> getTransfers(@PathVariable Integer station){
        List<Transfers> transfers = service.getAllTransfersByStation(station);

        if(transfers.isEmpty()) return ResponseEntity.ok(new ArrayList<>());

        ArrayList<Stations> stations = new ArrayList<>(transfers.size());

        for (Transfers transfer : transfers) {
            //El id enviado es igual al id de la estación A del transborde? Entonces agrega la estación con el id de B
            if(station.equals(transfer.getA()))
                stations.add(helper_service.getStation(transfer.getB()));
            //El id enviado es igual al id de la estación B del transborde? Entonces agrega la estación con el id de A
            else if(station.equals(transfer.getB()))
                stations.add(helper_service.getStation(transfer.getA()));
        }
        return ResponseEntity.ok(stations);
    }
}
