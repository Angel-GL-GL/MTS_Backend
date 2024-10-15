package com.services.api.mts_users.controllers;

import com.services.api.mts_users.models.Administrators;
import com.services.api.mts_users.models.Helper;
import com.services.api.mts_users.models.Helper_EU;
import com.services.api.mts_users.services.Administrators_Service;
import com.services.api.mts_users.services.Users_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Administrators_Controllers {
    @Autowired
    private Administrators_Service service;
    @Autowired
    private Users_Service user_service;
    //Login
    @RequestMapping(value = "api/administrator/sign-in", method = RequestMethod.POST)
    private ResponseEntity<Helper_EU> login(@RequestBody Helper administrator){
        Administrators administrators = service.getAdmin(administrator.getId());
        return ResponseEntity.ok(user_service.getUser(administrators.getUser(),administrator.getPassword(),1));
    }
}
