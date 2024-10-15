package com.services.api.mts_users.services;

import com.services.api.mts_users.models.Helper_EU;
import com.services.api.mts_users.models.Users;
import com.services.api.mts_users.repositories.Users_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

@Service
public class Users_Service {
    @Autowired
    private Users_Repository repository;
    @Autowired
    private EmailService emailService;
    //Usuarios
    public List<Users> getAllUsers(){return repository.findAll();}
    //Usuario por correo y contraseña
    public Helper_EU getUser(String email, String pass, int mode){
        List<Users> res = repository.findByEmailAndPassword(email,pass);
        if(!res.isEmpty()) {
            Helper_EU result = new Helper_EU();
            if(mode ==1){
                int randomFourDigit = ThreadLocalRandom.current().nextInt(1000, 10000);
                emailService.sendWelcomeEmail(email,
                        "2FA:",
                        "Querido usuario, le enviamos su 2FA:" + randomFourDigit
                );
                result.set_2fa(randomFourDigit);
            }
            result.setUsuario(res.get(0));
            return result;
        }else return new Helper_EU();
    }
    //Usuario por id y pass
    public Helper_EU getUser(Integer id, String pass, int mode){
        List<Users> res = repository.findByIdAndPassword(id,pass);
        if(!res.isEmpty()) {
            Helper_EU result = new Helper_EU();
            if(mode ==1){
                int randomFourDigit = ThreadLocalRandom.current().nextInt(1000, 10000);
                emailService.sendWelcomeEmail(res.get(0).getEmail(),
                        "2FA:",
                        "Querido usuario, le enviamos su 2FA:" + randomFourDigit
                );
                result.set_2fa(randomFourDigit);
            }
            result.setUsuario(res.get(0));
            return result;
        }else return new Helper_EU();
    }
    //Usuario por id y pass retornando boolean
    public boolean correctUser(Integer id, String pass){
        List<Users> res = repository.findByIdAndPassword(id,pass);
        return !res.isEmpty();
    }
    //Guardar
    public boolean setUser(Users user){
        if(repository.existsByEmail(user.getEmail())) return false;
        emailService.sendWelcomeEmail(
                user.getEmail(),
                "Bienvenido a nuestro E-commerce",
                "Querido " + user.getName() + ",\n\nGracias por registrarce a nuestra e-commerce. Emocionados de que uses nuestra plataforma :D!\n\nGracias,\nEl equipo de E-commerce"
        );
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
        Helper_EU support = getUser(users.getEmail(), users.getPassword(),0);
        repository.deleteById(support.getUsuario().getId());
        return true;
    }
}
