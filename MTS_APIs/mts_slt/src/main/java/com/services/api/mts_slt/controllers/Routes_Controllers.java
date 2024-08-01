package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Routes;
import com.services.api.mts_slt.services.Routes_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Routes_Controllers {
    @Autowired
    private Routes_Service service;
}
