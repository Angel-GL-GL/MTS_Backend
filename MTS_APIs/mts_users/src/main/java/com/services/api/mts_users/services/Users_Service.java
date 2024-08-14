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
    //Usuarios
    public List<Users> getAllUsers(){return repository.findAll();}
    //Usuario por correo y contraseña
    public Users getUser(String email, String pass){
        List<Users> res = repository.findByEmailAndPassword(email,pass);
        if(!res.isEmpty()) return res.get(0);
        else return new Users();
    }
    //Usuario por id y pass
    public Users getUser(Integer id, String pass){
        List<Users> res = repository.findByIdAndPassword(id,pass);
        if(!res.isEmpty()) return res.get(0);
        else return new Users();
    }
    //Usuario por id y pass retornando boolean
    public boolean correctUser(Integer id, String pass){
        List<Users> res = repository.findByIdAndPassword(id,pass);
        return !res.isEmpty();
    }
    //Guardar
    public boolean setUser(Users user){
        if(repository.existsByEmail(user.getEmail())) return false;
        repository.save(user);
        return true;
    }
    //Actualizar
    public boolean updateUser(Users user){
        repository.save(user);
        return true;
    }
    //usuario por correo
    public Users getUser(String email){
        List<Users> res = repository.findByEmail(email);
        if(!res.isEmpty()){
            Users user = res.get(0);
            user.setPassword("---");
            user.setCurp("---");
            user.setPhone("---");
            return user;
        }
        else return new Users();
    }
    //Borrar
    public boolean deleteUsers(Users users){
        Users support = getUser(users.getEmail(), users.getPassword());
        repository.deleteById(support.getId());
        return true;
    }
}
