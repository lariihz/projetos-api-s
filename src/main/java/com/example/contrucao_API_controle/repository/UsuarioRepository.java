package com.example.contrucao_API_controle.repository;

// Importações necessárias para o Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository; // Interface que fornece métodos prontos para CRUD
import org.springframework.stereotype.Repository; // Anotação para identificar como um repositório

import com.example.contrucao_API_controle.model.Usuario;

/**
 * Anotação para indicar que esta interface é um repositório Spring.
 * Um repositório é responsável pela interação com o banco de dados.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}