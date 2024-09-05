package com.services.api.mts_evidences.controllers;

import com.services.api.mts_evidences.models.Evidences;
import com.services.api.mts_evidences.models.REM;
import com.services.api.mts_evidences.services.Evidences_Service;
import com.services.api.mts_evidences.services.REM_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Evidences_Controller {
    @Autowired
    private Evidences_Service service;
    @Autowired
    private REM_Service rservice;

    //Obtener todas las evidencias
    @RequestMapping(value = "api/evidences", method = RequestMethod.GET)
    private ResponseEntity<List<Evidences>> getAllEvidences(){
        return ResponseEntity.ok(service.getAll());
    }

    //Crear evidencia
    @RequestMapping(value = "api/evidences/register", method = RequestMethod.POST)
    private boolean createEvidence(@RequestBody Evidences evidence){
        return service.create(evidence);
    }

    //Actualizar fecha y hora de envío
    @RequestMapping(value = "api/reports/update/shipment", method = RequestMethod.PUT)
    private boolean updateShipment(@RequestBody Evidences evidence){
        Evidences res = service.getEvidence(evidence.getId());
        if(!evidence.getId().equals(res.getId())) return false;
        service.addShipmentData(res.getId(),evidence.getShdate(),evidence.getShtime());
        return true;
    }

    //Obtener evidencia
    @RequestMapping(value = "api/evidences/{evidence}", method = RequestMethod.GET)
    private ResponseEntity<Evidences> getEvidence(@PathVariable Integer evidence){
        return ResponseEntity.ok(service.getEvidence(evidence));
    }

    //Obtener evidencia de un reporte
    @RequestMapping(value = "api/reports/{report}/evidences", method = RequestMethod.GET)
    private ResponseEntity<Evidences> getEvidenceByReport(@PathVariable Integer report){
        REM rem = rservice.getREMbyReport(report);
        if(!rem.getReport().equals(report)) return ResponseEntity.ok(new Evidences());
        return ResponseEntity.ok(service.getEvidence(rem.getEvidence()));
    }

    //Obtener evidencias por supervisor
    @RequestMapping(value = "api/supervisor/{supervisor}/evidences", method = RequestMethod.GET)
    private ResponseEntity<List<Evidences>> getEvidencesBySupervisor(@PathVariable String supervisor){
        List<REM> rems = rservice.getREMSbySupervisor(supervisor);
        if(rems.isEmpty()) return ResponseEntity.ok(new ArrayList<>());
        ArrayList<Evidences> evidences = new ArrayList<>();
        for(REM rem:rems){
            Evidences evidence = service.getEvidence(rem.getEvidence());
            if(evidence.getId().equals(rem.getEvidence())) evidences.add(evidence);
        }
        return ResponseEntity.ok(evidences);
    }
    //Guardar match
    @RequestMapping(value = "api/evidences/rem", method = RequestMethod.POST)
    private boolean createREM(@RequestBody REM rem){
        return rservice.create(rem);
    }
}
