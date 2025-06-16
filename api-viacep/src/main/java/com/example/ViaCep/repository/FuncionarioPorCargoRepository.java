package com.example.ViaCep.repository;

import com.example.ViaCep.model.FuncionarioPorCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioPorCargoRepository extends JpaRepository<FuncionarioPorCargo, Long> {
    List<FuncionarioPorCargo> findByCargoId(Long cargoId);
    List<FuncionarioPorCargo> findByFuncionarioId(Long funcionarioId);
}
