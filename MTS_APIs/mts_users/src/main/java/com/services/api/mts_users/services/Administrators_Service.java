package com.services.api.mts_users.services;

import com.services.api.mts_users.models.Administrators;
import com.services.api.mts_users.repositories.Administrators_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Administrators_Service {
    @Autowired
    private Administrators_Repository repository;

    public Administrators getAdmin(String id){
        List<Administrators> res = repository.findByAdmin(id);
        if(!res.isEmpty()) return res.get(0);
        else return new Administrators();
    }
}
