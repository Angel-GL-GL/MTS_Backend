package com.services.api.mts_evidences.repositories;

import com.services.api.mts_evidences.models.Evidences;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Evidences_Repository extends JpaRepository<Evidences,Integer>{
    //SELECT * FROM evidences WHERE evidence_creation_date = ?;
    List<Evidences> findByCrdate(LocalDate date);
    //SELECT * FROM evidences WHERE evidence_shipment_date = ?;
    List<Evidences> findByShdate(LocalDate date);
}
