package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Lines;
import com.services.api.mts_slt.services.Lines_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Lines_Controllers {
    @Autowired
    private Lines_Service service;
}
