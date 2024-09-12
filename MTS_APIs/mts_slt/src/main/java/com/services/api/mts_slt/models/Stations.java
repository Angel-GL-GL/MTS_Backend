package com.services.api.mts_slt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "stations")
public class Stations {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Integer id;
    @Column(name = "station_name")
    private String name;
    @Column(name = "station_line")
    private Integer line;
    @Column(name = "station_incident")
    private String incident;
    @Column(name = "station_services")
    private String services;
    @Column(name = "station_information")
    private String information;
/*
    @Column(name = "station_coord_x",precision = 30, scale = 15)
    private BigDecimal x;
    @Column(name = "station_coord_y",precision = 30, scale = 15)
    private BigDecimal y;
 */
}
