package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.OLMs;
import com.services.api.mts_slt.repositories.OLMs_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class OLMs_Service {
    @Autowired
    private OLMs_Repository repository;
    //Guardar
    public boolean create(OLMs olms){
        repository.save(olms);
        return true;
    }
    //OLMs
    public List<OLMs> getAll(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}
    //OLM por id
    public OLMs getOLM(Integer id){
        Optional<OLMs> os = repository.findById(id);
        return os.orElseGet(OLMs::new);
    }
    //Obtiene OLM por Opinion
    public OLMs getOLMByOpinion(Integer opinion){
        List<OLMs> res = repository.findByOpinion(opinion);
        if(res.isEmpty()) return new OLMs();
        return res.get(0);
    }
    //Obtiene OLMs por Estación
    public List<OLMs> getOLMsByLine(Integer line){
        List<OLMs> res = repository.findByLines(line);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(OLMs::getId));
        return res;
    }
    //Borrar
    public boolean delete(Integer id){
        repository.deleteById(id);
        return true;
    }
}
