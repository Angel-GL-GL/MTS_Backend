package com.services.api.mts_users.services;

import com.services.api.mts_users.models.Users;
import com.services.api.mts_users.repositories.Users_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Users_Service {
    @Autowired
    private Users_Repository repository;

    public List<Users> getAllUsers(){return repository.findAll();}

    public Users getUser(String email, String pass){
        List<Users> res = repository.findByEmailAndPassword(email,pass);
        if(!res.isEmpty()) return res.get(0);
        else return new Users();
    }

    public void setUser(Users user){
        if(!repository.existsByEmail(user.getEmail())) repository.save(user);
    }
//
//    public void removeUser(Users user){
//        if(!repository.existsByEmail(user.getEmail())){
//            List<Users> res = repository.findByEmailAndPassword(user.getEmail(),user.getPassword());
//            if(!res.isEmpty()){
//                System.out.println(res.get(0).getId());
//                repository.deleteById(res.get(0).getId());
//            }
//        }
//    }
}
