package com.services.api.mts_users.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "supervisors")
public class Supervisors {
    @Id
    @Column(name = "supervisor_id")
    private String sup;
    @Column(name = "supervisor_user")
    private Integer user;
    @Column(name = "supervisor_admin")
    private String admin;
    @Column(name = "supervisor_line")
    private Integer line;
    @Column(name = "supervisor_station")
    private Integer station;
}
