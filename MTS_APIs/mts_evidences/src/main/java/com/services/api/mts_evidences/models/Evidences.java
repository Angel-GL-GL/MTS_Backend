package com.services.api.mts_evidences.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "evidences")
public class Evidences {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "evidence_id")
    private Integer id;
    @Column(name = "evidence_creation_date")
    private LocalDate crdate;
    @Column(name = "evidence_creation_time")
    private LocalTime crtime;
    @Column(name = "evidence_shipment_date")
    private LocalDate shdate;
    @Column(name = "evidence_shipment_time")
    private LocalTime shtime;
    @Column(name = "evidence_body")
    private String body;
}
