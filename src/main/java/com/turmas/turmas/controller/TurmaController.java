package com.turmas.turmas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.turmas.alunos.entity.Aluno;
import com.turmas.turmas.dto.TurmaDTO;
import com.turmas.turmas.entity.Turma;
import com.turmas.turmas.service.TurmaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/turmas")
@AllArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public List<Turma> listarTurmas() {
      return turmaService.listarTurmas();
    }

    @PostMapping
    public ResponseEntity<?> criarTurma(@RequestBody TurmaDTO turmaDTO) {
      turmaService.criarTurma(turmaDTO);
      return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public Turma obterTurmaPorId(@PathVariable Long id) {
      return turmaService.obterTurmaPorId(id);
    }

    @GetMapping("/listarAlunos/{id}")
    public ResponseEntity<List<Aluno>> listarAlunos(@PathVariable String id) {
        List<Aluno> alunos = turmaService.listarAlunos(id);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
