package com.services.api.mts_users.controllers;

import com.services.api.mts_users.models.Helper;
import com.services.api.mts_users.models.Supervisors;
import com.services.api.mts_users.models.Users;
import com.services.api.mts_users.services.Supervisors_Service;
import com.services.api.mts_users.services.Users_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class Supervisors_Controllers {
    @Autowired
    private Supervisors_Service service;
    @Autowired
    private Users_Service user_service;
    //Register
    @RequestMapping(value = "api/supervisor/sign-up", method = RequestMethod.POST)
    private String register(@RequestBody Supervisors supervisors){
        String sup = "";
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
        sup = String.valueOf(randomNumber) + String.valueOf(supervisors.getLine()) + String.valueOf(supervisors.getStation());
        supervisors.setSup(sup);
        return service.setSupervisor(supervisors);
    }
    //Login
    @RequestMapping(value = "api/supervisor/sign-in", method = RequestMethod.POST)
    private ResponseEntity<Users> login(@RequestBody Helper supervisor){
        Supervisors supervisors = service.getSup(supervisor.getId());
        return ResponseEntity.ok(user_service.getUser(supervisors.getUser(),supervisor.getPassword()));
    }
    //Update
    @RequestMapping(value = "api/supervisor/update/profile",method = RequestMethod.PUT)
    private boolean update(@RequestBody Supervisors supervisors){
        Supervisors res = service.getSup(supervisors.getSup());
        if(!supervisors.getUser().equals(res.getUser())) return false;
        supervisors.setAdmin(res.getAdmin());
        supervisors.setUser(res.getUser());
        return service.updateSupervisor(supervisors);
    }
    //Delete
    @RequestMapping(value = "api/supervisor/delete/profile",method = RequestMethod.DELETE)
    private boolean delete(@RequestBody Helper supervisor){
        Supervisors supervisors = service.getSup(supervisor.getId());
        boolean band = user_service.correctUser(supervisors.getUser(),supervisor.getPassword());
        if(band) return service.deleteSupervisor(supervisors);
        return false;
    }
    @RequestMapping(value = "api/supervisors", method = RequestMethod.GET)
    private ResponseEntity<List<Supervisors>> get(){
        return ResponseEntity.ok(service.getAllSupervisors());
    }
}
