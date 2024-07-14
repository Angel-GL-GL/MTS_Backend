package com.services.api.mts_users.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrators")
public class Administrators {
    @Getter @Setter @Id
    @Column(name = "admin_id")
    private String admin;
    @Getter @Setter @Column(name = "admin_user")
    private Integer user;
    @Getter @Setter @Column(name = "admin_transport")
    private String transport;
}
