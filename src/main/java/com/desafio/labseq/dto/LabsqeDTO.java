package com.desafio.labseq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabsqeDTO {
    private int result;

    public static LabsqeDTO of(int n){
        return new LabsqeDTO(n);
    }
}
