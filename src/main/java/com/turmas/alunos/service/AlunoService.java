package com.turmas.alunos.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.turmas.alunos.dto.AlunoDTO;
import com.turmas.alunos.dto.AlunoMatriculaDTO;
import com.turmas.alunos.entity.Aluno;
import com.turmas.alunos.repository.AlunoRepository;
import com.turmas.turmas.entity.Turma;
import com.turmas.turmas.repository.TurmaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public List<Aluno> listarAlunos() {
        return this.alunoRepository.findAll();
    }

    public Aluno obterAlunoPorId(Long id) {
        return this.alunoRepository.findById(id).orElseThrow();
    }

    public void criarAluno(AlunoDTO alunoDTO) {
        final Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        this.alunoRepository.save(aluno);
    }

    public void matricularAluno(AlunoMatriculaDTO alunoMatriculaDTO) {
        Aluno aluno = alunoRepository.findByMatricula(alunoMatriculaDTO.getMatricula());
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado para a matrícula: " + alunoMatriculaDTO.getMatricula());
        }
    
        List<Turma> turmas = turmaRepository.findAllByIdIn(alunoMatriculaDTO.getTurmas());
    
        for (Turma turma : turmas) {
            if (!turma.getAlunos().contains(aluno)) {
                turma.getAlunos().add(aluno);
                turmaRepository.save(turma);
            }
        }
    }   

    public List<Turma> listarTurmas(String matricula) {
        Aluno aluno = alunoRepository.findByMatricula(matricula);

        if (aluno != null) {
            return turmaRepository.findByAlunosContains(aluno);
        } else {
            throw new RuntimeException("Aluno não encontrado para a matrícula: " + matricula);
        }
    }
}
