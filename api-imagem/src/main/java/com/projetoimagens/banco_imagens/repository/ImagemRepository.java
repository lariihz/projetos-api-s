package com.projetoimagens.banco_imagens.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projetoimagens.banco_imagens.model.ImagemModel;

@Repository
public interface ImagemRepository extends JpaRepository<ImagemModel, Long> {
    // Não precisa adicionar nada por enquanto — o JpaRepository já nos dá os métodos prontos!
}
