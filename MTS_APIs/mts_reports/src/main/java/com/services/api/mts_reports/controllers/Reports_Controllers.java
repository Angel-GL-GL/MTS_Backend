package com.services.api.mts_reports.controllers;

import com.services.api.mts_reports.models.Helper;
import com.services.api.mts_reports.models.REM;
import com.services.api.mts_reports.models.Reports;
import com.services.api.mts_reports.services.REM_Service;
import com.services.api.mts_reports.services.Reports_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Reports_Controllers {
    @Autowired
    private Reports_Service service;
    @Autowired
    private REM_Service rservice;

    //Obtener todos los reportes
    @RequestMapping(value = "api/reports", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getAllReports(){
        return ResponseEntity.ok(service.getAllReports());
    }

    //Crear reporte
    @RequestMapping(value = "api/reports/register", method = RequestMethod.POST)
    private boolean createReport(@RequestBody Reports reports){
        return service.createReport(reports);
    }

    //Obtener reporte
    @RequestMapping(value = "api/reports/{report}", method = RequestMethod.GET)
    private ResponseEntity<Reports> getReport(@PathVariable Integer report){
        return ResponseEntity.ok(service.getReport(report));
    }

    //Obtener reportes de un transporte
    @RequestMapping(value = "api/transports/reports", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTransport(@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByTransport(helper.getTransport()));
    }

    //Obtener reportes de una línea
    @RequestMapping(value = "api/lines/{line}/reports", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByLine(@PathVariable Integer line){
        return ResponseEntity.ok(service.getReportByLine(line));
    }

    //Obtener reportes de una ruta
    @RequestMapping(value = "api/routes/{route}/reports", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByRoute(@PathVariable Integer route){
        return ResponseEntity.ok(service.getReportByRoute(route));
    }

    //Obtener reportes de una estación
    @RequestMapping(value = "api/stations/{station}/reports", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByStation(@PathVariable Integer station){
        return ResponseEntity.ok(service.getReportByStation(station));
    }

    //Obtener reportes de un usuario
    @RequestMapping(value = "api/user/{user}/reports", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByUser(@PathVariable Integer user){
        return ResponseEntity.ok(service.getReportsByUser(user));
    }

    //Obtener reportes de una fecha
    @RequestMapping(value = "api/reports/date", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportsByDate(@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDate(helper.getDate()));
    }

//    //Obtener reportes de una fecha
//    @RequestMapping(value = "api/reports/date/time", method = RequestMethod.POST)
//    private ResponseEntity<List<Reports>> getReportsByDateAndTime(@RequestBody Helper helper){
//        return ResponseEntity.ok(service.getReportByTimeAndDate(
//                helper.getTime(),helper.getDate()
//        ));
//    }

    //Obtener reportes con un estatus
    @RequestMapping(value = "api/reports/status/{status}", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByStation(@PathVariable String status){
        return ResponseEntity.ok(service.getReportByStatus(status));
    }

    //Obtener reportes de un transporte en una fecha
    @RequestMapping(value = "api/transports/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndTransport(@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDateAndTransport(
                helper.getDate(),helper.getTransport()
        ));
    }

    //Obtener reportes de una línea en una fecha
    @RequestMapping(value = "api/lines/{line}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndLine(@PathVariable Integer line,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDateAndLine(
                helper.getDate(),line
        ));
    }

    //Obtener reportes de una ruta en una fecha
    @RequestMapping(value = "api/routes/{route}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndRoute(@PathVariable Integer route,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDateAndRoute(
                helper.getDate(),route
        ));
    }

    //Obtener reportes de una estación en una fecha
    @RequestMapping(value = "api/stations/{station}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndStation(@PathVariable Integer station,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDateAndStation(
                helper.getDate(),station
        ));
    }

    //Obtener reportes de un usuario en una fecha
    @RequestMapping(value = "api/user/{user}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndUser(@PathVariable Integer user,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDateAndUser(
                helper.getDate(),user
        ));
    }


    //Obtener reportes de una evidencia
    @RequestMapping(value = "api/evidences/{evidence}/reports", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByEvidence(@PathVariable Integer evidence){
        List<REM> rems = rservice.getREMSbyEvidence(evidence);
        if(rems.isEmpty()) return ResponseEntity.ok(new ArrayList<>());
        ArrayList<Reports> evidences = new ArrayList<>();
        for(REM rem:rems){
            Reports report = service.getReport(rem.getEvidence());
            if(report.getId().equals(rem.getEvidence())) evidences.add(report);
        }
        return ResponseEntity.ok(evidences);
    }

    //Actualizar status
    @RequestMapping(value = "api/reports/update/status", method = RequestMethod.PUT)
    private boolean updateStatus(@RequestBody Reports reports){
        Reports res = service.getReport(reports.getId());
        if(!reports.getId().equals(res.getId())) return false;
        service.changeStatus(res.getId(),reports.getStatus());
        return true;
    }
}
