package com.turmas.turmas.dto;
import lombok.Data;

@Data
public class TurmaDTO {
    private String sigla;
    private String descricao;
    private int ano;
    private int semestre;
    private int vagasMax;
    private int vagasMin;
}
