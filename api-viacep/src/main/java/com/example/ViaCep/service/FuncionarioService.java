package com.example.ViaCep.service;

import com.example.ViaCep.model.Funcionario;
import com.example.ViaCep.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public Funcionario salvar(Funcionario funcionario) {
        return repo.save(funcionario);
    }

    public List<Funcionario> listar() {
        return repo.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return repo.existsById(id);
    }
}
