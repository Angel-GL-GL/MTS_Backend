package com.services.api.mts_evidences.services;

import com.services.api.mts_evidences.models.REM;
import com.services.api.mts_evidences.repositories.REM__Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class REM_Service {
    @Autowired
    private REM__Repository repository;

    //Guardar
    public boolean create(REM rem){
        repository.save(rem);
        return true;
    }

    //REMS por reporte
    public List<REM> getREMSbyReport(Integer report){
        List<REM> res = repository.findByReport(report);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(REM::getId));
        return res;
    }

    //REMS por evidencia
    public List<REM> getREMSbyEvidence(Integer evidence){
        List<REM> res = repository.findByEvidence(evidence);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(REM::getId));
        return res;
    }

    //REMS por supervisor
    public List<REM> getREMSbySupervisor(Integer supervisor){
        List<REM> res = repository.findBySupervisor(supervisor);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(REM::getId));
        return res;
    }
}
