package com.services.api.mts_slt.controllers;

import com.services.api.mts_slt.models.Opinions;
import com.services.api.mts_slt.models.OLMs;
import com.services.api.mts_slt.models.OSMs;
import com.services.api.mts_slt.services.Opinions_Service;
import com.services.api.mts_slt.services.OLMs_Service;
import com.services.api.mts_slt.services.OSMs_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Service
public class Opinions_Controllers {
    @Autowired
    private Opinions_Service service;
    @Autowired
    private OLMs_Service olmss;
    @Autowired
    private OSMs_Service osmss;

    //Registrar Opinion en estación
    @RequestMapping(value = "api/stations/{station}/opinions/register", method = RequestMethod.POST)
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
    @RequestMapping(value = "api/lines/{line}/opinions/register", method = RequestMethod.POST)
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
        if(osms.getOpinion().equals(res.getId())) f2 = osmss.delete(osms.getId());
        else if(olms.getOpinion().equals(res.getId())) f2 = olmss.delete(olms.getId());
        boolean f1 = service.delete(res.getId());
        return f1&&f2;
    }
}
