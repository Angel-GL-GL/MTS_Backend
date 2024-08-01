package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Transfers;
import com.services.api.mts_slt.services.Transfers_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Transfers_Controllers {
    @Autowired
    private Transfers_Service service;
}
