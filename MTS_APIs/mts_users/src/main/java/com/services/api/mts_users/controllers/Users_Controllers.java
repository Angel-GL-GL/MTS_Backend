package com.services.api.mts_users.controllers;

import com.services.api.mts_users.models.Users;
import com.services.api.mts_users.services.Users_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Users_Controllers {
    @Autowired
    private Users_Service service;
    //Register
    @RequestMapping(value = "api/sign-up", method = RequestMethod.POST)
    private void register(@RequestBody Users user){
        service.setUser(user);
    }
    //Login
    @RequestMapping(value = "api/sign-in", method = RequestMethod.POST)
    private ResponseEntity<Users> login(@RequestBody Users user){
        return ResponseEntity.ok(service.getUser(user.getEmail(),user.getPassword()));
    }
    //delete
//    @RequestMapping(value = "api/delete", method = RequestMethod.DELETE)
//    private void delete(@RequestBody Users user){
//        service.removeUser(user);
//    }
}
