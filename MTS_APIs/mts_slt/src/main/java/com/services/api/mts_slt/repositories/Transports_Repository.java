package com.services.api.mts_slt.repositories;

import com.services.api.mts_slt.models.Transports;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Transports_Repository extends JpaRepository<Transports,String> {
    //SELECT * FROM transports WHERE transport_price = ?;
    //List<Transports> findByPrice(Integer price);
}
