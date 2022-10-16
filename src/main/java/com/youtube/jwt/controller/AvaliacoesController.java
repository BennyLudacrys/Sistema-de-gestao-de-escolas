package com.youtube.jwt.controller;


import com.youtube.jwt.dao.AvaliacoesRepository;
import com.youtube.jwt.entity.Avaliacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("avaliacao")
public class AvaliacoesController {

    @Autowired
    private AvaliacoesRepository avaliacoesRepository;
    @GetMapping("/listar")
    private List<Avaliacoes> listar(){
        List<Avaliacoes> avaliacoes = avaliacoesRepository.findAll();
        return avaliacoes;
    }
    @PostMapping
    private Avaliacoes inserir(@RequestBody Avaliacoes avaliacoes){
      Avaliacoes avaliacoesSalvo = avaliacoesRepository.save(avaliacoes);
      return avaliacoesSalvo;

    }

    @GetMapping("/{id}")
    public Avaliacoes buscar (@PathVariable Integer id){
        Optional<Avaliacoes> resultado = avaliacoesRepository.findById(id);
            Avaliacoes avaliacoes = resultado.get();
        return avaliacoes;
      }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Avaliacoes excluir(@PathVariable Integer id){
        Optional<Avaliacoes> administrador = avaliacoesRepository.findById(id);
        avaliacoesRepository.delete(administrador.get());
        Avaliacoes avaliacaoRetorno = administrador.get();
        return avaliacaoRetorno;
    }

    @PutMapping
    private Avaliacoes editar (@RequestBody Avaliacoes administrador){
        Avaliacoes administradorEditado = avaliacoesRepository.save(administrador);
        return administradorEditado;
    }
}
