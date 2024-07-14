package com.services.api.mts_users.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supervisors")
public class Supervisors {
    @Getter @Setter @Id
    @Column(name = "supervisor_id")
    private String sup;
    @Getter @Setter @Column(name = "supervisor_user")
    private Integer user;
    @Getter @Setter @Column(name = "supervisor_admin")
    private String admin;
    @Getter @Setter @Column(name = "supervisor_line")
    private Integer line;
    @Getter @Setter @Column(name = "supervisor_station")
    private Integer station;
}
