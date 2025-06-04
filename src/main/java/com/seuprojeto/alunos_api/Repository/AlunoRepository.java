package com.seuprojeto.alunos_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seuprojeto.alunos_api.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
