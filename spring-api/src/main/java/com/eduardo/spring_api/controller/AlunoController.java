package com.eduardo.spring_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.spring_api.model.Aluno;
import com.eduardo.spring_api.service.AlunoService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.ok().body("Aluno deletado com sucesso");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.update(id, aluno);
        return ResponseEntity.ok().body("Aluno atualizado com sucesso: " + alunoAtualizado.getNome());
    }

}
