package com.services.api.mts_users.repositories;

import com.services.api.mts_users.models.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Administrators_Repository extends JpaRepository<Administrators,String>{
    //SELECT * FROM administrators WHERE administrator_id = ?;
    List<Administrators> findByAdmin(String id);
}
