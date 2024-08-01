package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Stations;
import com.services.api.mts_slt.services.Stations_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Stations_Controllers {
    @Autowired
    private Stations_Service service;
}
