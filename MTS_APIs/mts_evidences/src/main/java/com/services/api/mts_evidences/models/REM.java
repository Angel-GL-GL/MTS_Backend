package com.services.api.mts_evidences.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "reports_evidences_match")
public class REM {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "rem_id")
    private Integer id;
    @Column(name = "rem_report")
    private Integer report;
    @Column(name = "rem_evidence")
    private Integer evidence;
    @Column(name = "rem_supervisor")
    private String supervisor;
}
