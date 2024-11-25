package com.example.mspago.dto;

import lombok.Data;

@Data
public class InscriptionDto {
    private Integer id;
    private String number;
    private InscriptionDetailDto inscriptionDetail;
}
