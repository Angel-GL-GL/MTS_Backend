package com.services.api.mts_evidences.services;

import com.services.api.mts_evidences.models.Evidences;
import com.services.api.mts_evidences.repositories.Evidences_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class Evidences_Service {
    @Autowired
    private Evidences_Repository repository;
    //Guardar
    public boolean create(Evidences evidences){
        repository.save(evidences);
        return true;
    }

    //Evidencias
    public List<Evidences> getAll(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}

    //Obtiene evidencia
    public Evidences getEvidence(Integer id){
        Optional<Evidences> os = repository.findById(id);
        return os.orElseGet(Evidences::new);
    }

    //Evidencias por fecha de creación
    public List<Evidences> getEvidencesByCrDate(LocalDate cr_date){
        List<Evidences> res = repository.findByCrdate(cr_date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Evidences::getId));
        return res;
    }

    //Evidencias por fecha de envio
    public List<Evidences> getEvidencesByShDate(LocalDate sh_date){
        List<Evidences> res = repository.findByShdate(sh_date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Evidences::getId));
        return res;
    }
}
