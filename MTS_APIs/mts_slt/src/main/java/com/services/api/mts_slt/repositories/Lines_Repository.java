package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Lines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
public interface Lines_Repository extends JpaRepository<Lines,Integer>{
    //SELECT * FROM lines WHERE line_transport = ?;
    List<Lines> findByTransport(String transport);
    //SELECT * FROM lines WHERE line_name = ? AND line_transport = ?;
    Lines findByNameAndTransport(String name, String transport);
    //SELECT * FROM lines WHERE line_incident = ?;
    List<Lines> findByIncident(String incident);
}
