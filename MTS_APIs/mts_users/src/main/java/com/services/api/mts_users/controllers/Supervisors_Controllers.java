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

@RestController
public class Supervisors_Controllers {
    @Autowired
    private Supervisors_Service service;
    @Autowired
    private Users_Service user_service;
    //Register
    @RequestMapping(value = "api/supervisor/sign-up", method = RequestMethod.POST)
    private boolean register(@RequestBody Supervisors supervisors){
        boolean res = service.setSupervisor(supervisors);
        return res;
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
    private boolean delete(@RequestBody Supervisors supervisors){
        return service.deleteSupervisor(supervisors);
    }
//    @RequestMapping(value = "api/supervisors", method = RequestMethod.GET)
//    private ResponseEntity<List<Supervisors>> get(){
//        return ResponseEntity.ok(service.getAllSupervisors());
//    }
}