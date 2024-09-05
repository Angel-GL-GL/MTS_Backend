package com.services.api.mts_reports.repositories;

import com.services.api.mts_reports.models.REM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface REM__Repository extends JpaRepository<REM,Integer>{
    //SELECT * FROM reports_evidences_match WHERE rem_evidence = ?;
    List<REM> findByEvidence(Integer evidence);

}
