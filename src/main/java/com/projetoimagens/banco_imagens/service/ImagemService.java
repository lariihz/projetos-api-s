package com.projetoimagens.banco_imagens.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoimagens.banco_imagens.model.ImagemModel;
import com.projetoimagens.banco_imagens.repository.ImagemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    public ImagemModel salvarImagem(ImagemModel imagem) {
        return imagemRepository.save(imagem);
    }

    public List<ImagemModel> listarImagens() {
        return imagemRepository.findAll();
    }

    public Optional<ImagemModel> buscarImagemPorId(Long id) {
        return imagemRepository.findById(id);
    }

    public void deletarImagem(Long id) {
        imagemRepository.deleteById(id);
    }

    public ImagemModel atualizarImagem(Long id, ImagemModel novaImagem) {
        return imagemRepository.findById(id).map(imagem -> {
            imagem.setNome(novaImagem.getNome());
            imagem.setUrl(novaImagem.getUrl());
            return imagemRepository.save(imagem);
        }).orElseThrow(() -> new RuntimeException("Imagem não encontrada com ID: " + id));
    }
}
