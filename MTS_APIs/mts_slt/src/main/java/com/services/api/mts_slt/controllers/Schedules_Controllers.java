package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.*;
import com.services.api.mts_slt.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Schedules_Controllers {
    @Autowired
    private Schedules_Service service;
    @Autowired
    private RSMs_Service rsms_service;
    @Autowired
    private Routes_Service routes_service;
    @Autowired
    private Lines_Service lines_service;
    @Autowired
    private Transports_Service transports_service;

    @RequestMapping(value = "api/schedules/{station}", method = RequestMethod.GET)
    private ResponseEntity<ArrayList<ScheduleHelper>> getSchedules(@PathVariable Integer station){
        List<RSMs> matches = rsms_service.getAllRSMsByStation(station);

        if(matches.isEmpty()) return ResponseEntity.ok(new ArrayList<ScheduleHelper>());

        ArrayList<ScheduleHelper> res = new ArrayList<>();

        for(RSMs rsm: matches){
            ScheduleHelper schedules = new ScheduleHelper();
            List<Schedules> sc = service.getAllSchedulesByRoute(rsm.getRoute());
            schedules.add(sc);
            Routes r = routes_service.getRoute(rsm.getRoute());
            Lines l = lines_service.getLine(r.getLine());
            Transports t = transports_service.getTransport(l.getTransport());
            RouteHelper rh = new RouteHelper();
            rh.setRoutes(r.getName());
            rh.setLines(l.getName());
            rh.setTransports(t.getName());
            schedules.add(rh);
            res.add(schedules);
        }

        return ResponseEntity.ok(res);
    }
}
