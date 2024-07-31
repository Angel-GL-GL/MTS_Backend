package com.services.api.mts_users.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "administrators")
public class Administrators {
    @Id
    @Column(name = "admin_id")
    private String admin;
    @Column(name = "admin_user")
    private Integer user;
    @Column(name = "admin_transport")
    private String transport;
}
