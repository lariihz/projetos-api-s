package com.example.ViaCep.controller;

import com.example.ViaCep.model.FuncionarioPorCargo;
import com.example.ViaCep.service.FuncionarioPorCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/funcionarios-por-cargo")
public class FuncionarioPorCargoController {

    @Autowired
    private FuncionarioPorCargoService service;

    @PostMapping
    public FuncionarioPorCargo criar(@RequestBody FuncionarioPorCargo fpc) {
        return service.salvar(fpc);
    }

    @GetMapping
    public List<FuncionarioPorCargo> listarTodos(
        @RequestParam(required = false) Long cargoId,
        @RequestParam(required = false) Long funcionarioId
    ) {
        if (cargoId != null) return service.filtrarPorCargo(cargoId);
        if (funcionarioId != null) return service.filtrarPorFuncionario(funcionarioId);
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioPorCargo> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioPorCargo> atualizar(@PathVariable Long id, @RequestBody FuncionarioPorCargo fpc) {
        return service.buscarPorId(id)
                .map(obj -> {
                    fpc.setId(id);
                    return ResponseEntity.ok(service.salvar(fpc));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
