package com.services.api.mts_users.repositories;

import com.services.api.mts_users.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Users_Repository extends JpaRepository<Users, Integer> {

    //SELECT * FROM users WHERE user_email = ? AND user_password = ?;
    List<Users> findByEmailAndPassword(String email, String password);
    //Verifica que exista el email
    Boolean existsByEmail(String email);
}
