package com.turmas.turmas.entity;

import java.util.List;

import com.turmas.alunos.entity.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sigla;
    private String descricao;
    private int ano;
    private int semestre;
    private int vagasMax;
    private int vagasMin;

    @ManyToMany
    private List<Aluno> alunos;
}
