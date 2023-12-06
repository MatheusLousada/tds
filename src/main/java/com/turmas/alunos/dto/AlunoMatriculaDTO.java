package com.turmas.alunos.dto;
import java.util.List;

import lombok.Data;

@Data
public class AlunoMatriculaDTO {
    public String matricula;
    public List<Long> turmas;
}
