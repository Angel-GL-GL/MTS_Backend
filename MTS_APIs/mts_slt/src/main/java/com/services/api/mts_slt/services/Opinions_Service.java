package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Opinions;
import com.services.api.mts_slt.repositories.Opinions_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class Opinions_Service {
    @Autowired
    private Opinions_Repository repository;
    //Guardar
    public boolean create(Opinions opinions){
        repository.save(opinions);
        return true;
    }
    //Opiniones
    public List<Opinions> getAll(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}
    //Opinion por id
    public Opinions getOpinions(Integer id){
        Optional<Opinions> os = repository.findById(id);
        return os.orElseGet(Opinions::new);
    }
    //Obtiene Opiniones por usuario
    public List<Opinions> getOpinionByUser(Integer user){
        List<Opinions> res = repository.findByUser(user);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Obtiene Opiniones por tipo
    public List<Opinions> getOpinionByType(String type){
        List<Opinions> res = repository.findByType(type);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Obtiene Opiniones por fecha
    public List<Opinions> getOpinionByDate(LocalDate date){
        List<Opinions> res = repository.findByDate(date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Obtiene Opiniones por usuario y tipo
    public List<Opinions> getOpinionByUserAndType(Integer user, String type){
        List<Opinions> res = repository.findByUserAndType(user, type);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Obtiene Opiniones por usuario y fecha
    public List<Opinions> getOpinionByUserAndDate(Integer user, LocalDate date){
        List<Opinions> res = repository.findByUserAndDate(user,date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Obtiene Opiniones por tipo y fecha
    public List<Opinions> getOpinionByTypeAndDate(String type, LocalDate date){
        List<Opinions> res = repository.findByTypeAndDate(type,date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Obtiene Opiniones por usuario, tipo y fecha
    public List<Opinions> getOpinionByUserAndTypeAndDate(Integer user, String type, LocalDate date){
        List<Opinions> res = repository.findByUserAndTypeAndDate(user,type,date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Opinions::getId));
        return res;
    }
    //Actualizar
    public void update(Opinions opinions){
        repository.save(opinions);
    }
    //Borrar
    public boolean delete(Integer id){
        repository.deleteById(id);
        return true;
    }
}
