package com.example.ViaCep.controller;

import com.example.ViaCep.model.Cargo;
import com.example.ViaCep.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @PostMapping
    public Cargo criar(@RequestBody Cargo cargo) {
        return service.salvar(cargo);
    }

    @GetMapping
    public List<Cargo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody Cargo cargo) {
        return service.buscarPorId(id).map(c -> {
            cargo.setId(id);
            return ResponseEntity.ok(service.salvar(cargo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
