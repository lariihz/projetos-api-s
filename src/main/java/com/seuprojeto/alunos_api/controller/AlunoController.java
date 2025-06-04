package com.seuprojeto.alunos_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seuprojeto.alunos_api.Repository.AlunoRepository;
import com.seuprojeto.alunos_api.model.Aluno;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*") // PARA DESENVOLVIMENTO: permite requisições de qualquer origem
public class AlunoController {

  @Autowired
  private AlunoRepository alunoRepository;

  // GET all alunos
  @GetMapping
  public List<Aluno> getAllAlunos() {
    return alunoRepository.findAll();
  }

  // POST novo aluno
  @PostMapping
  public Aluno createAluno(@RequestBody Aluno aluno) {
    System.out.println("Recebido: " + aluno.getNome() + ", " + aluno.getEmail());
    return alunoRepository.save(aluno);
  }

  // DELETE aluno por id
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAluno(@PathVariable Long id) {
    return alunoRepository.findById(id).map(aluno -> {
      alunoRepository.delete(aluno);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }

  // PUT atualizar aluno
  @PutMapping("/{id}")
  public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetalhes) {
    return alunoRepository.findById(id).map(aluno -> {
      aluno.setNome(alunoDetalhes.getNome());
      aluno.setEmail(alunoDetalhes.getEmail());
      Aluno atualizado = alunoRepository.save(aluno);
      return ResponseEntity.ok(atualizado);
    }).orElse(ResponseEntity.notFound().build());
  }
}
