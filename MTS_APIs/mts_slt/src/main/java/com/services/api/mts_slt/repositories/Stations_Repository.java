package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Stations_Repository extends JpaRepository<Stations,Integer>{
    //SELECT * FROM stations WHERE station_line = ?;
    List<Stations> findByLine(Integer line);
    //SELECT * FROM stations WHERE station_name = ?;
    List<Stations> findByName(String name);
    //SELECT * FROM stations WHERE station_name = ? AND station_line = ?;
    Stations findByNameAndLine(String name, Integer Line);
    //SELECT * FROM stations WHERE station_incident = ?;
    List<Stations> findByIncident(String incident);
    //SELECT * FROM stations WHERE station_incident <> ?;
    List<Stations> findByIncidentNot(String incident);
}
