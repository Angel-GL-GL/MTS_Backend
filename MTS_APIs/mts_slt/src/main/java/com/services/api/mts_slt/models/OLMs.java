package com.services.api.mts_slt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "opinions_lines_match")
public class OLMs {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "olm_id")
    private Integer id;
    @Column(name = "olm_opinion")
    private Integer opinion;
    @Column(name = "olm_line")
    private Integer line;
}
