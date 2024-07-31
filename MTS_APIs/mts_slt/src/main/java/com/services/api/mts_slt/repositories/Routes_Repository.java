package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Routes_Repository extends JpaRepository<Routes,Integer>{
    //SELECT * FROM routes WHERE route_name = ?;
    List<Routes> findByName(String name);
    //SELECT * FROM routes WHERE route_line = ?;
    List<Routes> findByLine(Integer line);
}
