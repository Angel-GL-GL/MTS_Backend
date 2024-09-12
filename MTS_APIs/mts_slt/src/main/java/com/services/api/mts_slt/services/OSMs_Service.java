package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.OSMs;
import com.services.api.mts_slt.repositories.OSMs_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class OSMs_Service {
    @Autowired
    private OSMs_Repository repository;
    //Guardar
    public boolean create(OSMs osms){
        repository.save(osms);
        return true;
    }
    //OSMs
    public List<OSMs> getAll(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}
    //OSM por id
    public OSMs getOSM(Integer id){
        Optional<OSMs> os = repository.findById(id);
        return os.orElseGet(OSMs::new);
    }
    //Obtiene OSM por Opinion
    public OSMs getOSMByOpinion(Integer opinion){
        List<OSMs> res = repository.findByOpinion(opinion);
        if(res.isEmpty()) return new OSMs();
        return res.get(0);
    }
    //Obtiene OSMs por Estación
    public List<OSMs> getOSMsByStation(Integer station){
        List<OSMs> res = repository.findByStation(station);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(OSMs::getId));
        return res;
    }
    //Borrar
    public boolean delete(Integer id){
        repository.deleteById(id);
        return true;
    }
}
