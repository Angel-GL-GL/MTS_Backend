package com.services.api.mts_users.services;

import com.services.api.mts_users.models.Supervisors;
import com.services.api.mts_users.repositories.Supervisors_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Supervisors_Service {
    @Autowired
    private Supervisors_Repository repository;
    //Supervisores
    public List<Supervisors> getAllSupervisors(){return repository.findAll();}
    //Supervisor
    public Supervisors getSup(String id){
        List<Supervisors> res = repository.findBySup(id);
        if(!res.isEmpty()) return res.get(0);
        return new Supervisors();
    }
    //Supervisores del admin
    public List<Supervisors> getAllSupervisors_Admin(String admin){
        List<Supervisors> res = repository.findByAdmin(admin);
        if(!res.isEmpty()) return res;
        return new ArrayList<>();
    }
    //Supervisores de la línea
    public List<Supervisors> getAllSupervisors_Line(Integer line){
        List<Supervisors> res = repository.findByLine(line);
        if(!res.isEmpty()) return res;
        return new ArrayList<>();
    }
    //Supervisores de la estación
    public List<Supervisors> getAllSupervisors_Station(Integer station){
        List<Supervisors> res = repository.findByStation(station);
        if(!res.isEmpty()) return res;
        return new ArrayList<>();
    }
    //guardar
    public String setSupervisor(Supervisors supervisors){
        if(repository.existsByStation(supervisors.getStation())) return " ";
        if(repository.existsByUser(supervisors.getUser())) return " ";
        if(repository.existsBySup(supervisors.getSup())) return " ";
        repository.save(supervisors);
        return supervisors.getSup();
    }
    //actualizar
    public boolean updateSupervisor(Supervisors supervisors){
        repository.save(supervisors);
        return true;
    }
    //Borrar
    public boolean deleteSupervisor(Supervisors supervisors){
        repository.deleteById(supervisors.getSup());
        return true;
    }
}
