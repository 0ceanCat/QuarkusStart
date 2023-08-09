package com.desafio.labseq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabsqeDTO {
    private String result;

    public static LabsqeDTO of(BigInteger n){
        return new LabsqeDTO(n.toString());
    }
}
