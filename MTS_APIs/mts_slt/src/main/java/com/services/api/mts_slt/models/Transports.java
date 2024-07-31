package com.services.api.mts_slt.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "transports")
public class Transports {
    @Id
    @Column(name = "transport_name")
    private String name;
    @Column(name = "transport_speed", precision = 4, scale = 2)
    private BigDecimal speed;
    @Column(name = "transport_price")
    private Integer price;
}
