package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Transports;
import com.services.api.mts_slt.services.Transports_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Transports_Controllers {
    @Autowired
    private Transports_Service service;
}
