package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Lines;
import com.services.api.mts_slt.repositories.Lines_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Lines_Service {
    @Autowired
    private Lines_Repository repository;
    //Lineas
    public List<Lines> getAllLines(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}
    //Línea
    public Lines getLine(Integer id){
        Optional<Lines> os = repository.findById(id);
        return os.orElseGet(Lines::new);
    }
    //Línea
    public Lines getLine(String name, String transport){
        return repository.findByNameAndTransport(name,transport);
    }
    //Líneas por transporte
    public List<Lines> getAllLinesByTransport(String transport){
        List<Lines> res = repository.findByTransport(transport);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Lines::getId));
        return res;
    }
    //Líneas por incidente
    public List<Lines> getAllLinesByIncident(String incident){
        List<Lines> res = repository.findByIncident(incident);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Lines::getId));
        return res;
    }
    //Líneas de velocidad mayor a 0
    public List<Lines> getAllLinesBySpeed(){
        List<Lines> res = repository.findAll();
        res = res.stream()
                .filter(line -> line.getSpeed().compareTo(BigDecimal.ZERO) != 0)
                .collect(Collectors.toList());
        res.sort(Comparator.comparing(Lines::getId));
        return res;
    }
    //Actualizar
    public void updateIncident(Lines line){
        repository.save(line);
    }
}
