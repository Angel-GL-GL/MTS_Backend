package com.services.api.mts_slt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "opinions_stations_match")
public class OSMs {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "osm_id")
    private Integer id;
    @Column(name = "osm_opinion")
    private Integer opinion;
    @Column(name = "osm_station")
    private Integer station;
}
