package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Opinions;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface Opinions_Repository extends JpaRepository<Opinions,Integer>{
    //SELECT * FROM opinions WHERE opinion_user = ?;
    List<Opinions> findByUser(Integer user);
    //SELECT * FROM opinions WHERE opinion_type = ?;
    //List<Opinions> findByType(String type);
    //SELECT * FROM opinions WHERE opinion_date = ?;
    List<Opinions> findByDate(LocalDate date);
    //SELECT * FROM opinions WHERE opinion_user = ? && opinion_type = ?;
    //List<Opinions> findByUserAndType(Integer user, String type);
    //SELECT * FROM opinions WHERE opinion_user = ? && opinion_date = ?;
    //List<Opinions> findByUserAndDate(Integer user, LocalDate date);
    //SELECT * FROM opinions WHERE opinion_type = ? && opinion_date = ?;
    //List<Opinions> findByTypeAndDate(String type, LocalDate date);
    //SELECT * FROM opinions WHERE opinion_user = ? && opinion_type = ? && opinion_date = ?;
    List<Opinions> findByUserAndTypeAndDate(Integer user, String type, LocalDate date);
}
