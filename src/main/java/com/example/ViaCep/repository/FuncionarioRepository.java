package com.example.ViaCep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ViaCep.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {}
