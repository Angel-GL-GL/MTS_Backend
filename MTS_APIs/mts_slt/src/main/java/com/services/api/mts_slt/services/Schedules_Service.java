package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Schedules;
import com.services.api.mts_slt.repositories.Schedules_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Schedules_Service {
    @Autowired
    private Schedules_Repository repository;

    public List<Schedules> getAllSchedules(){return repository.findAll();}

    public Schedules getSchedule(Integer id){
        Optional<Schedules> os = repository.findById(id);
        return os.orElseGet(Schedules::new);
    }

    public List<Schedules> getAllSchedulesByRoute(Integer route){
        List<Schedules> res = repository.findByRoute(route);

        if(!res.isEmpty()) return res;
        else return new ArrayList<>();
    }
}
