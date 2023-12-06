package com.turmas.turmas.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turmas.alunos.entity.Aluno;
import com.turmas.turmas.dto.TurmaDTO;
import com.turmas.turmas.entity.Turma;
import com.turmas.turmas.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listarTurmas() {
        return this.turmaRepository.findAll();
    }

    public void criarTurma(TurmaDTO turmaDTO) {
        final Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        this.turmaRepository.save(turma);
    }

    public Turma obterTurmaPorId(Long id) {
        return this.turmaRepository.findById(id).orElseThrow();
    }

    public List<Aluno> listarAlunos(String turmaId) {
        Long id = Long.valueOf(turmaId);
        Turma turma = turmaRepository.findById(id).orElseThrow();
        return turma.getAlunos();
    }
}
