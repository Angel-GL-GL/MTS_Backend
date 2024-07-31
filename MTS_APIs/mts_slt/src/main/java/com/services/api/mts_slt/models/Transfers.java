package com.services.api.mts_slt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "transfers")
public class Transfers {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "transfer_id")
    private Integer id;
    @Column(name = "transfer_station_a")
    private Integer a;
    @Column(name = "transfer_station_b")
    private Integer b;
    @Column(name = "transfer_price")
    private Integer price;
}
