package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Schedules;
import com.services.api.mts_slt.services.Schedules_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Schedules_Controllers {
    @Autowired
    private Schedules_Service service;
}
