package com.example.contrucao_API_controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.contrucao_API_controle.model.Saida;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long>{
    
}