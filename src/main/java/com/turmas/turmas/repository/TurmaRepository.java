package com.turmas.turmas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turmas.alunos.entity.Aluno;
import com.turmas.turmas.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("SELECT t FROM Turma t WHERE t.id IN :turmaIds")
    List<Turma> findAllByIdIn(@Param("turmaIds") List<Long> turmaIds);

    @Query("SELECT DISTINCT t FROM Turma t JOIN t.alunos a WHERE a = :aluno")
    List<Turma> findByAlunosContains(@Param("aluno") Aluno aluno);
}
