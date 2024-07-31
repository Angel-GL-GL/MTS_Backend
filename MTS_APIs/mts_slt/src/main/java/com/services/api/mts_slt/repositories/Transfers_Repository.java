package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Transfers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Transfers_Repository extends JpaRepository<Transfers,Integer>{
    //SELECT * FROM transfers WHERE transfer_station_a = ?;
    List<Transfers> findByA(Integer a);
    //SELECT * FROM transfers WHERE transfer_station_b = ?;
    List<Transfers> findByB(Integer b);
}
