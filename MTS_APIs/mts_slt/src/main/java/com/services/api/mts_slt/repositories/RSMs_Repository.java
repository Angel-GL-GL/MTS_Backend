package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.RSMs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RSMs_Repository extends JpaRepository<RSMs,Integer>{
    //SELECT * FROM routes_stations_match WHERE rsm_route = ?;
    List<RSMs> findByRoute(Integer route);
    //SELECT * FROM routes_stations_match WHERE rsm_station = ?;
    List<RSMs> findByStation(Integer station);
}
