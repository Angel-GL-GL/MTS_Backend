package com.services.api.mts_slt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "opinions")
public class Opinions {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "opinion_id")
    private Integer id;
    @Column(name = "opinion_user")
    private Integer user;
    @Column(name = "opinion_date")
    private LocalDate date;
    @Column(name = "opinion_time")
    private LocalTime time;
    @Column(name = "opinion_body")
    private String body;
    @Column(name = "opinion_type")
    private String type;
}
