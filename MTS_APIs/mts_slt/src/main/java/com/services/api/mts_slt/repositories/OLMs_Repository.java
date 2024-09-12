package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.OLMs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OLMs_Repository extends JpaRepository<OLMs,Integer>{
    //SELECT * FROM opinions_lines_match WHERE olm_opinion = ?;
    List<OLMs> findByOpinion(Integer line);
    //SELECT * FROM opinions_lines_match WHERE olm_line = ?;
    List<OLMs> findByLines(Integer line);
}
