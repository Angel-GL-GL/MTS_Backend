package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Stations;
import com.services.api.mts_slt.repositories.Stations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class Stations_Service {
    @Autowired
    private Stations_Repository repository;
}
