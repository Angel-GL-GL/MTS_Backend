package com.services.api.mts_users.controllers;

import com.services.api.mts_users.models.Users;
import com.services.api.mts_users.services.Users_Service;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Users_Controllers {
    @Autowired
    private Users_Service service;
    //Login
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    private ResponseEntity<Users> get(@RequestBody Users user){
        return ResponseEntity.ok(service.getUser(user.getEmail(),user.getPassword()));
    }
    //Todos los pedidos
    @RequestMapping(value = "users", method = RequestMethod.GET)
    private ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(service.getAllUsers());
    }
}
