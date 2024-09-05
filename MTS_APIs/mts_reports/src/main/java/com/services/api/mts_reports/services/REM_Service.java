package com.services.api.mts_reports.services;

import com.services.api.mts_reports.models.REM;
import com.services.api.mts_reports.repositories.REM__Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class REM_Service {
    @Autowired
    private REM__Repository repository;

    //REMS por evidencia
    public List<REM> getREMSbyEvidence(Integer evidence){
        List<REM> res = repository.findByEvidence(evidence);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(REM::getId));
        return res;
    }
}
