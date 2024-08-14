package com.services.api.mts_reports.repositories;

import com.services.api.mts_reports.models.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Reports_Repository extends JpaRepository<Reports,Integer>{
    //SELECT * FROM reports WHERE report_user = ?;
    List<Reports> findByUser(Integer user);
    //SELECT * FROM reports WHERE report_transport = ?;
    List<Reports> findByTransport(String transport);
    //SELECT * FROM reports WHERE report_line = ?;
    List<Reports> findByLine(Integer line);
    //SELECT * FROM reports WHERE report_station = ?;
    List<Reports> findByStation(Integer station);
    //SELECT * FROM reports WHERE report_date = ?;
    List<Reports> findByDate(LocalDate date);
    //SELECT * FROM reports WHERE report_time = ?;
    List<Reports> findByTime(LocalTime time);
    //SELECT * FROM reports WHERE report_status = ?;
    List<Reports> findByStatus(String status);
    //SELECT * FROM reports WHERE report_time = ? AND report_date = ?;
    List<Reports> findByTimeAndDate(LocalTime time,LocalDate date);
    //SELECT * FROM reports WHERE report_time = ? AND report_date = ? AND report_station = ?;
    List<Reports> findByTimeAndDateAndStation(LocalTime time,LocalDate date, Integer Station);
    //SELECT * FROM reports WHERE report_time = ? AND report_date = ? AND report_line = ?;
    List<Reports> findByTimeAndDateAndLine(LocalTime time,LocalDate date, Integer Line);
    //SELECT * FROM reports WHERE report_time = ? AND report_date = ? AND report_transport = ?;
    List<Reports> findByTimeAndDateAndTransport(LocalTime time,LocalDate date, String Transport);

}
