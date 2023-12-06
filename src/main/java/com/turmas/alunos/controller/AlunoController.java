package com.turmas.alunos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.turmas.alunos.dto.AlunoDTO;
import com.turmas.alunos.dto.AlunoMatriculaDTO;
import com.turmas.alunos.entity.Aluno;
import com.turmas.alunos.service.AlunoService;
import com.turmas.turmas.entity.Turma;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/alunos")
@AllArgsConstructor
public class AlunoController {

  private final AlunoService alunoService;

  @GetMapping
  public List<Aluno> listarAlunos() {
    return alunoService.listarAlunos();
  }

  @GetMapping("/{id}")
  public Aluno obterAlunoPorId(@PathVariable Long id) {
    return alunoService.obterAlunoPorId(id);
  }

  @PostMapping
  public ResponseEntity<?> criarAluno(@RequestBody AlunoDTO alunoDTO) {
    alunoService.criarAluno(alunoDTO);
    return ResponseEntity.status(201).build();
  }

  @PostMapping("/matricular")
  public ResponseEntity<?> matricularAluno(@RequestBody AlunoMatriculaDTO alunoMatriculaDTO) {
    alunoService.matricularAluno(alunoMatriculaDTO);
    return ResponseEntity.status(201).build();
  }

  @GetMapping("/listarTurmas/{matricula}")
  public List<Turma> listarTurmas(@PathVariable String matricula) {
    return alunoService.listarTurmas(matricula);
  }
}