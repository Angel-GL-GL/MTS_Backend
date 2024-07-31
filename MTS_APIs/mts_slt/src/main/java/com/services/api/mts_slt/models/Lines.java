package com.services.api.mts_slt.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "lines")
public class Lines {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Integer id;
    @Column(name = "line_name")
    private String name;
    @Column(name = "line_transport")
    private String transport;
    @Column(name = "line_incident")
    private String incident;
    @Column(name = "line_speed", precision = 4, scale = 2)
    private BigDecimal speed;
    @Column(name = "line_information")
    private String information;

}
