package com.example.msinscripcion.entity;

import com.example.msinscripcion.dto.EventDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InscriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Double amount;
    private Integer EventId;
    @Transient
    private EventDto eventDto;
    public InscriptionDetail() {
        this.price = (double) 0;
        this.amount = (double) 0;
    }
}
