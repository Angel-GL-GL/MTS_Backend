package com.services.api.mts_slt.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "schedules")
public class Schedules {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer id;
    @Column(name = "schedule_open_hour")
    private LocalTime open;
    @Column(name = "schedule_close_hour")
    private LocalTime close;
    @Column(name = "schedule_day")
    private String day;
    @Column(name = "schedule_route")
    private Integer route;
}
