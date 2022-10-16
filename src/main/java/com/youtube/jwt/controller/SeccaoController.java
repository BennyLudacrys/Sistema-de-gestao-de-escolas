package com.youtube.jwt.controller;


import com.youtube.jwt.dao.SeccaoRepository;
import com.youtube.jwt.entity.Avaliacoes;
import com.youtube.jwt.entity.Seccao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seccao")
public class SeccaoController {
    @Autowired
    private SeccaoRepository seccaoRepository;
    @GetMapping("/listar")
    private List<Seccao> listar(){
        List<Seccao> planificacao = seccaoRepository.findAll();
        return planificacao;
    }
    @PostMapping
    private Seccao inserir(@RequestBody Seccao seccao){
        Seccao seccaoSalva = seccaoRepository.save(seccao);
        return seccaoSalva;

    }

    @GetMapping("/{id}")
    public Seccao buscar (@PathVariable Integer id){
        Optional<Seccao> resultado = seccaoRepository.findById(id);
        Seccao seccao = resultado.get();
        return seccao;
    }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Seccao excluir(@PathVariable Integer id){
        Optional<Seccao> seccao = seccaoRepository.findById(id);
        seccaoRepository.delete(seccao.get());
        Seccao avaliacaoRetorno = seccao.get();
        return avaliacaoRetorno;
    }

    @PutMapping
    private Seccao editar (@RequestBody Seccao seccao){
        Seccao seccaoEditado = seccaoRepository.save(seccao);
        return seccaoEditado;
    }
}
