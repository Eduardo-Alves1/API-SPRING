package com.eduardo.spring_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.spring_api.model.Aluno;
import com.eduardo.spring_api.service.AlunoService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@AllArgsConstructor
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Aluno aluno) {

        Aluno novoAluno = alunoService.criar(aluno);
        
        return ResponseEntity.ok().body("Novo aluno criado com sucesso: " + novoAluno.getNome());
    }

  
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(alunoService.listar());
    }

}
