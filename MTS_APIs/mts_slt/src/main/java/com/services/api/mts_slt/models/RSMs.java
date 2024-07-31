package com.services.api.mts_slt.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "routes_stations_match")
public class RSMs {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "rsm_id")
    private Integer id;
    @Column(name = "rsm_route")
    private Integer route;
    @Column(name = "rsm_station")
    private Integer station;
}
