package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Opinions;
import com.services.api.mts_slt.models.OLMs;
import com.services.api.mts_slt.models.OSMs;
import com.services.api.mts_slt.services.Opinions_Service;
import com.services.api.mts_slt.services.OLMs_Service;
import com.services.api.mts_slt.services.OSMs_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Opinions_Controllers {
    @Autowired
    private Opinions_Service service;
    @Autowired
    private OLMs_Service olmss;
    @Autowired
    private OSMs_Service osmss;

    //Actualizar opinion
    @RequestMapping(value = "api/opinions", method = RequestMethod.PUT)
    private boolean update(@RequestBody Opinions opinions){
        Opinions res = service.getOpinions(opinions.getId());
        if(!opinions.getId().equals(res.getId())) return false;
        res.setBody(opinions.getBody());
        res.setType(opinions.getType());
        service.update(res);
        return true;
    }

    //Eliminar opinion
    @RequestMapping(value = "api/opinions", method = RequestMethod.DELETE)
    private boolean delete(@RequestBody Opinions opinions){
        Opinions res = service.getOpinions(opinions.getId());
        if(!opinions.getId().equals(res.getId())) return false;
        OSMs osms = osmss.getOSMByOpinion(res.getId());
        OLMs olms = olmss.getOLMByOpinion(res.getId());
        boolean f2 = false;
        if(osms != null && osms.getOpinion() != null && osms.getOpinion().equals(res.getId())) f2 = osmss.delete(osms.getId());
        else if(olms != null && olms.getOpinion() != null && olms.getOpinion().equals(res.getId())) f2 = olmss.delete(olms.getId());
        boolean f1 = service.delete(res.getId());
        return f1&&f2;
    }

    //Registrar Opinion en estación
    @RequestMapping(value = "api/stations/{station}/opinions", method = RequestMethod.POST)
    private boolean createOpinionStation(@RequestBody Opinions opinions, @PathVariable Integer station){
        boolean f1 = service.create(opinions);
        OSMs osms = new OSMs();
        osms.setOpinion(
                service.getOpinionByUserAndTypeAndDate(
                        opinions.getUser(),
                        opinions.getType(),
                        opinions.getDate(),
                        opinions.getBody()
                ).getId()
        );
        osms.setStation(station);
        boolean f2 = osmss.create(osms);
        return f1&&f2;
    }

    //Registrar Opinion en linea
    @RequestMapping(value = "api/lines/{line}/opinions", method = RequestMethod.POST)
    private boolean createOpinionLine(@RequestBody Opinions opinions, @PathVariable Integer line){
        boolean f1 = service.create(opinions);
        OLMs olms = new OLMs();
        olms.setOpinion(
            service.getOpinionByUserAndTypeAndDate(
                opinions.getUser(),
                opinions.getType(),
                opinions.getDate(),
                opinions.getBody()
            ).getId()
        );
        olms.setLine(line);
        boolean f2 = olmss.create(olms);
        return f1&&f2;
    }

    //Obtiene opiniones de una estación
    @RequestMapping(value = "api/stations/{station}/opinions", method = RequestMethod.GET)
    private ResponseEntity<List<Opinions>> getOpStations(@PathVariable Integer station){
        List<OSMs> osms = osmss.getOSMsByStation(station);
        if(osms.isEmpty()) return ResponseEntity.ok(new ArrayList<>());
        ArrayList<Opinions> opinions = new ArrayList<>();
        for(OSMs osm: osms) opinions.add(service.getOpinions(osm.getOpinion()));
        return ResponseEntity.ok(opinions);
    }

    //Obtiene opiniones de una linea
    @RequestMapping(value = "api/lines/{line}/opinions", method = RequestMethod.GET)
    private ResponseEntity<List<Opinions>> getOpLines(@PathVariable Integer line){
        List<OLMs> olms = olmss.getOLMsByLine(line);
        if(olms.isEmpty()) return ResponseEntity.ok(new ArrayList<>());
        ArrayList<Opinions> opinions = new ArrayList<>();
        for(OLMs olm: olms) opinions.add(service.getOpinions(olm.getOpinion()));
        return ResponseEntity.ok(opinions);
    }

    //Obtiene opiniones de un usuario
    @RequestMapping(value = "api/user/{user}/opinions", method = RequestMethod.GET)
    private ResponseEntity<List<Opinions>> getOpUs(@PathVariable Integer user){
        List<Opinions> opinions = service.getOpinionByUser(user);
        if(opinions.isEmpty()) return ResponseEntity.ok(new ArrayList<>());
        return ResponseEntity.ok(opinions);
    }

    //Registrar Opinion en linea
    @RequestMapping(value = "api/opinions/date", method = RequestMethod.POST)
    private ResponseEntity<List<Opinions>> getOpDate(@RequestBody Opinions op){
        List<Opinions> opinions = service.getOpinionByDate(op.getDate());
        if(opinions.isEmpty()) return ResponseEntity.ok(new ArrayList<>());
        return ResponseEntity.ok(opinions);
    }
}
