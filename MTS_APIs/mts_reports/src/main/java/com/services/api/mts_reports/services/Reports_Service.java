package com.services.api.mts_reports.services;

import com.services.api.mts_reports.models.Reports;
import com.services.api.mts_reports.repositories.Reports_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class Reports_Service {
    @Autowired
    private Reports_Repository repository;
    //Guardar
    public boolean createReport(Reports reports){
        repository.save(reports);
        return true;
    }

    //Reportes
    public List<Reports> getAllReports(){return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));}

    //Obtiene reporte
    public Reports getReport(Integer id){
        Optional<Reports> os = repository.findById(id);
        return os.orElseGet(Reports::new);
    }

    //Reportes por usuario
    public List<Reports> getReportsByUser(Integer user){
        List<Reports> res = repository.findByUser(user);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }

    //Reportes por transporte
    public List<Reports> getReportByTransport(String transport){
        List<Reports> res = repository.findByTransport(transport);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }

    //Reportes por línea
    public List<Reports> getReportByLine(Integer line){
        List<Reports> res = repository.findByLine(line);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }

    //Reportes por ruta
    public List<Reports> getReportByRoute(Integer route){
        List<Reports> res = repository.findByRoute(route);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }

    //Reportes por estación
    public List<Reports> getReportByStation(Integer station){
        List<Reports> res = repository.findByStation(station);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }

    //Reportes por fecha
    public List<Reports> getReportByDate(LocalDate date){
        List<Reports> res = repository.findByDate(date);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }
//
//    //Reportes por hora
//    public List<Reports> getReportByTime(LocalTime time){
//        List<Reports> res = repository.findByTime(time);
//        if(res.isEmpty()) return new ArrayList<>();
//        res.sort(Comparator.comparing(Reports::getId));
//        return res;
//    }

    //Reportes por estatus
    public List<Reports> getReportByStatus(String status){
        List<Reports> res = repository.findByStatus(status);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getId));
        return res;
    }

//    //Reportes por hora y fecha
//    public List<Reports> getReportByTimeAndDate(LocalTime time, LocalDate date){
//        List<Reports> res = repository.findByTimeAndDate(time,date);
//        if(res.isEmpty()) return new ArrayList<>();
//        res.sort(Comparator.comparing(Reports::getStatus).thenComparing(Reports::getId));
//        return res;
//    }

    //Reportes por fecha y transporte
    public List<Reports> getReportByDateAndTransport(LocalDate date, String transport){
        List<Reports> res = repository.findByDateAndTransport(date,transport);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getStatus).thenComparing(Reports::getId));
        return res;
    }

    //Reportes por fecha y línea
    public List<Reports> getReportByDateAndLine(LocalDate date, Integer line){
        List<Reports> res = repository.findByDateAndLine(date,line);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getStatus).thenComparing(Reports::getId));
        return res;
    }

    //Reportes por fecha y ruta
    public List<Reports> getReportByDateAndRoute(LocalDate date, Integer route){
        List<Reports> res = repository.findByDateAndRoute(date,route);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getStatus).thenComparing(Reports::getId));
        return res;
    }

    //Reportes por fecha y estación
    public List<Reports> getReportByDateAndStation(LocalDate date, Integer station){
        List<Reports> res = repository.findByDateAndStation(date,station);
        if(res.isEmpty()) return new ArrayList<>();
        res.sort(Comparator.comparing(Reports::getStatus).thenComparing(Reports::getId));
        return res;
    }

    //Editar status
    public boolean changeStatus(Integer id, String status){
        Reports reports = getReport(id);
        if(!reports.getId().equals(id)) return false;
        reports.setStatus(status);
        repository.save(reports);
        return true;
    }
}
