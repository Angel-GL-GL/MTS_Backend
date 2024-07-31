package com.services.api.mts_users.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_lastname_pat")
    private String lastname_pat;
    @Column(name = "user_lastname_mat")
    private String lastname_mat;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_curp")
    private String curp;
    @Column(name = "user_ocupation")
    private String ocuparion;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_phone")
    private String phone;
}
