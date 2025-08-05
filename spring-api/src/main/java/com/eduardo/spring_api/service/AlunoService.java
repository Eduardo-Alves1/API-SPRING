package com.eduardo.spring_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardo.spring_api.model.Aluno;
import com.eduardo.spring_api.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno criar(Aluno aluno) {

        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno update(Long id, Aluno aluno) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

}
