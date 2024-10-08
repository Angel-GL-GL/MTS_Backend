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
    private boolean register(@RequestBody Users user){
        boolean res = service.setUser(user);
        return res;
    }
    //Login
    @RequestMapping(value = "api/sign-in", method = RequestMethod.POST)
    private ResponseEntity<Users> login(@RequestBody Users user){
        return ResponseEntity.ok(service.getUser(user.getEmail(),user.getPassword()));
    }
    //Update
    @RequestMapping(value = "api/update/profile",method = RequestMethod.PUT)
    private boolean update(@RequestBody Users user){
        Users res = service.getUser(user.getEmail(),user.getPassword());
        if(!user.getEmail().equals(res.getEmail())) return false;
        user.setCurp(res.getCurp());
        user.setId(res.getId());
        return service.updateUser(user);
    }
    //Get user
    @RequestMapping(value = "api/userByEmail/{email}", method = RequestMethod.GET)
    private ResponseEntity<Users> get(@PathVariable String email){
        return ResponseEntity.ok(service.getUser(email));
    }

    //delete
    @RequestMapping(value = "api/delete", method = RequestMethod.DELETE)
    private boolean delete(@RequestBody Users user){
        return service.deleteUsers(user);
    }

    //    //Login-supervisor_admin-support
//    @RequestMapping(value = "api/sup/sign-in", method = RequestMethod.POST)
//    private ResponseEntity<Users> login_support(@RequestBody Users user){
//        return ResponseEntity.ok(service.getUser(user.getId(),user.getPassword()));
//    }
}
