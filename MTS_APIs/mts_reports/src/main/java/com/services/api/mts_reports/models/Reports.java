package com.services.api.mts_reports.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "reports")
public class Reports {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer id;
    @Column(name = "report_user")
    private Integer user;
    @Column(name = "report_transport")
    private String transport;
    @Column(name = "report_line")
    private Integer line;
    @Column(name = "report_route")
    private Integer route;
    @Column(name = "report_station")
    private Integer station;
    @Column(name = "report_date")
    private LocalDate date;
    @Column(name = "report_time")
    private LocalTime time;
    @Column(name = "report_body")
    private String body;
    @Column(name = "report_status")
    private String status;
    @Column(name = "report_coord_x")
    private String x;
    @Column(name = "report_coord_y")
    private String y;

}
