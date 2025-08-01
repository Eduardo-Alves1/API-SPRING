package com.eduardo.spring_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.eduardo.spring_api.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno>findByNomeContainingIgnoreCase(String nome);


}
