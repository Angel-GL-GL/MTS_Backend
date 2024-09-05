package com.services.api.mts_evidences.repositories;

import com.services.api.mts_evidences.models.REM;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface REM__Repository extends JpaRepository<REM,Integer>{
    //SELECT * FROM reports_evidences_match WHERE rem_report = ?;
    List<REM> findByReport(Integer report);
    //SELECT * FROM reports_evidences_match WHERE rem_evidence = ?;
    List<REM> findByEvidence(Integer evidence);
    //SELECT * FROM reports_evidences_match WHERE rem_supervisor = ?;
    List<REM> findBySupervisor(Integer supervisor);

}
