package com.services.api.mts_users.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class Users {
    @Getter @Setter @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Getter @Setter @Column(name = "user_name")
    private String name;
    @Getter @Setter @Column(name = "user_lastname_pat")
    private String lastname_pat;
    @Getter @Setter @Column(name = "user_lastname_mat")
    private String lastname_mat;
    @Getter @Setter @Column(name = "user_email")
    private String email;
    @Getter @Setter @Column(name = "user_curp")
    private String curp;
    @Getter @Setter @Column(name = "user_ocupation")
    private String ocuparion;
    @Getter @Setter @Column(name = "user_password")
    private String password;
    @Getter @Setter @Column(name = "user_phone")
    private String phone;
}
