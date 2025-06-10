package com.example.ViaCep.service;

import com.example.ViaCep.model.Cargo;
import com.example.ViaCep.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repo;

    public Cargo salvar(Cargo cargo) {
        return repo.save(cargo);
    }

    public List<Cargo> listar() {
        return repo.findAll();
    }

    public Optional<Cargo> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return repo.existsById(id);
    }
}
