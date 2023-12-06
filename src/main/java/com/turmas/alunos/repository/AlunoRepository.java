package com.turmas.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turmas.alunos.entity.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("SELECT a FROM Aluno a WHERE a.matricula = :matricula")
    Aluno findByMatricula(@Param("matricula") String matricula);
}
