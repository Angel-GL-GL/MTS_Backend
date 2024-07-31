package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Transfers;
import com.services.api.mts_slt.repositories.Transfers_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class Transfers_Service {
    @Autowired
    private Transfers_Repository repository;

    public List<Transfers> getAllTransfers(){return repository.findAll();};

    public List<Transfers> getAllTransfersByStation(Integer station){
        List<Transfers> res_a = repository.findByA(station);
        List<Transfers> res_b = repository.findByB(station);

        if(res_a.isEmpty() && !res_b.isEmpty()) return res_b;
        else if(!res_a.isEmpty() && res_b.isEmpty()) return res_a;
        else if(res_a.isEmpty()) return new ArrayList<>();

        List<Transfers> fusion = new ArrayList<>(res_a.size() + res_b.size());
        fusion.addAll(res_a);
        fusion.addAll(res_b);
        return fusion;
    }
}
