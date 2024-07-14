package com.services.api.mts_users.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrators")
public class Administrators {
    @Getter @Setter @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer id;
    @Getter @Setter @Column(name = "admin_user")
    private String name;
}
