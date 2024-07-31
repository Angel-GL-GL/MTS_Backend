package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Schedules_Repository extends JpaRepository<Schedules,Integer>{
    //SELECT * FROM schedules WHERE schedule_route = ?;
    List<Schedules> findByRoute(Integer route);
    //SELECT * FROM schedules WHERE schedule_day = ?;
    List<Schedules> findByDay(String day);
}
