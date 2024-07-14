package com.services.api.mts_users.controllers;

import com.services.api.mts_users.models.Administrators;
import com.services.api.mts_users.services.Administrators_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Administrators_Controllers {
    @Autowired
    private Administrators_Service service;
}
