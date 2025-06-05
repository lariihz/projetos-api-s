package com.projetoimagens.banco_imagens.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projetoimagens.banco_imagens.model.ImagemModel;
import com.projetoimagens.banco_imagens.service.ImagemService;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/imagens")
@CrossOrigin(origins = "*")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    // POST - Adiciona uma nova imagem
    @PostMapping
    public ImagemModel adicionarImagem(@RequestBody ImagemModel imagem) {
        return imagemService.salvarImagem(imagem);
    }

    // GET - Lista todas as imagens
    @GetMapping
    public List<ImagemModel> listarImagens() {
        return imagemService.listarImagens();
    }

    // DELETE - Remove uma imagem por ID
    @DeleteMapping("/{id}")
    public void deletarImagem(@PathVariable Long id) {
        imagemService.deletarImagem(id);
    }

    // PUT - Atualiza uma imagem por ID
    @PutMapping("/{id}")
    public ImagemModel atualizarImagem(@PathVariable Long id, @RequestBody ImagemModel imagem) {
        return imagemService.atualizarImagem(id, imagem);
    }
}
