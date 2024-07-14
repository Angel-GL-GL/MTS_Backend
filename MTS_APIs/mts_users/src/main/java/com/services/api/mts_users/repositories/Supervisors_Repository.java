package com.services.api.mts_users.repositories;

import com.services.api.mts_users.models.Supervisors;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Supervisors_Repository extends JpaRepository<Supervisors,String>{

    //SELECT * FROM supervisors WHERE supervisor_id = ?;
    List<Supervisors> findBySup(String id);
    //SELECT * FROM supervisors WHERE supervisor_admin = ?;
    List<Supervisors> findByAdmin(String supervisor_admin);
    //SELECT * FROM supervisors WHERE supervisor_line = ?;
    List<Supervisors> findByLine(Integer supervisor_line);
    //SELECT * FROM supervisors WHERE supervisor_station = ?;
    List<Supervisors> findByStation(Integer supervisor_station);
    //Verifica que exista un registro con el mismo id de usuario
    Boolean existsByUser(Integer user);
    //Verifica que exista un registro con la estación
    Boolean existsByStation(Integer station);
    //Verifica que exista un registro con el id
    Boolean existsBySup(String id);
}
