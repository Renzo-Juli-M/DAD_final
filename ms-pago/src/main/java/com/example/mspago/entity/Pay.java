package com.example.mspago.entity;

import com.example.mspago.dto.InscriptionDetailDto;
import com.example.mspago.dto.InscriptionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "pays")
public class Pay {
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pay_id")
    private List<Pay> Pays;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String payment_method;
    private String status;
    private Integer InscriptionId;
    @Transient
    private InscriptionDto inscriptionDto;


}
