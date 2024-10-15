package com.services.api.mts_users.controllers;

import com.services.api.mts_users.models.Helper_EU;
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
    private ResponseEntity<Helper_EU> login(@RequestBody Users user){
        return ResponseEntity.ok(service.getUser(user.getEmail(),user.getPassword(),1));
    }
    //Update
    @RequestMapping(value = "api/update/profile",method = RequestMethod.PUT)
    private boolean update(@RequestBody Users user){
        Helper_EU res = service.getUser(user.getEmail(),user.getPassword(), 0);
        Users userbd = res.getUsuario();
        if(!user.getEmail().equals(userbd.getEmail())) return false;
        user.setCurp(userbd.getCurp());
        user.setId(userbd.getId());
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

    //TodosUsuarios
    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    private ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    //    //Login-supervisor_admin-support
//    @RequestMapping(value = "api/sup/sign-in", method = RequestMethod.POST)
//    private ResponseEntity<Users> login_support(@RequestBody Users user){
//        return ResponseEntity.ok(service.getUser(user.getId(),user.getPassword()));
//    }
}
