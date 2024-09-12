package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.OSMs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OSMs_Repository extends JpaRepository<OSMs,Integer>{
    //SELECT * FROM opinions_stations_match WHERE osm_opinion = ?;
    List<OSMs> findByOpinion(Integer line);
    //SELECT * FROM opinions_stations_match WHERE osm_station = ?;
    List<OSMs> findByStation(Integer line);
}
