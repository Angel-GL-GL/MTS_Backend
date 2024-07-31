package com.services.api.mts_slt.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "routes")
public class Routes {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Integer id;
    @Column(name = "route_name")
    private String name;
    @Column(name = "route_line")
    private Integer line;
}
