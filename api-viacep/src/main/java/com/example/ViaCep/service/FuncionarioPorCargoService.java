package com.example.ViaCep.service;

import com.example.ViaCep.model.FuncionarioPorCargo;
import com.example.ViaCep.repository.FuncionarioPorCargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioPorCargoService {

    @Autowired
    private FuncionarioPorCargoRepository repository;

    public FuncionarioPorCargo salvar(FuncionarioPorCargo fpc) {
        return repository.save(fpc);
    }

    public List<FuncionarioPorCargo> listar() {
        return repository.findAll();
    }

    public Optional<FuncionarioPorCargo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<FuncionarioPorCargo> filtrarPorCargo(Long cargoId) {
        return repository.findByCargoId(cargoId);
    }

    public List<FuncionarioPorCargo> filtrarPorFuncionario(Long funcionarioId) {
        return repository.findByFuncionarioId(funcionarioId);
    }
}
