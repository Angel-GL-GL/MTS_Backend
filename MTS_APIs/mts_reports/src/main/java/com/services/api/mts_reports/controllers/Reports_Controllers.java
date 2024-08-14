package com.services.api.mts_reports.controllers;

import com.services.api.mts_reports.models.Helper;
import com.services.api.mts_reports.models.Reports;
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

    //Obtener reportes de una fecha
    @RequestMapping(value = "api/reports/date", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportsByDate(@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByDate(helper.getDate()));
    }

    //Obtener reportes de una fecha
    @RequestMapping(value = "api/reports/date/time", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportsByDateAndTime(@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByTimeAndDate(
                helper.getTime(),helper.getDate()
        ));
    }

    //Obtener reportes con un estatus
    @RequestMapping(value = "api/reports/status/{status}", method = RequestMethod.GET)
    private ResponseEntity<List<Reports>> getReportByStation(@PathVariable String status){
        return ResponseEntity.ok(service.getReportByStatus(status));
    }

    //Obtener reportes de un transporte en una fecha y hora
    @RequestMapping(value = "api/transports/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndTransport(@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByTimeAndDateAndTransport(
                helper.getTime(),helper.getDate(),helper.getTransport()
        ));
    }

    //Obtener reportes de una línea en una fecha y hora
    @RequestMapping(value = "api/lines/{line}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndLine(@PathVariable Integer line,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByTimeAndDateAndLine(
                helper.getTime(),helper.getDate(),line
        ));
    }

    //Obtener reportes de una ruta en una fecha y hora
    @RequestMapping(value = "api/routes/{route}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndRoute(@PathVariable Integer route,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByTimeAndDateAndRoute(
                helper.getTime(),helper.getDate(),route
        ));
    }

    //Obtener reportes de una estación en una fecha y hora
    @RequestMapping(value = "api/stations/{station}/reports/search", method = RequestMethod.POST)
    private ResponseEntity<List<Reports>> getReportByTimeAndDateAndStation(@PathVariable Integer station,@RequestBody Helper helper){
        return ResponseEntity.ok(service.getReportByTimeAndDateAndStation(
                helper.getTime(),helper.getDate(),station
        ));
    }

    //Actualizar status
    @RequestMapping(value = "api/reports/update/incident", method = RequestMethod.PUT)
    private boolean updateStatus(@RequestBody Reports reports){
        Reports res = service.getReport(reports.getId());
        if(!reports.getId().equals(res.getId())) return false;
        service.changeStatus(res.getId(),reports.getStatus());
        return true;
    }
}
