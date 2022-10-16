package com.youtube.jwt.controller;

import com.youtube.jwt.dao.PlanificacaoRepository;
import com.youtube.jwt.entity.Avaliacoes;
import com.youtube.jwt.entity.Planificacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planificacao")
public class PlanificacaoController {
    @Autowired
    private PlanificacaoRepository planificacaoRepository;

    @GetMapping("/listar")
    private List<Planificacao> listar(){
        List<Planificacao> planificacao = planificacaoRepository.findAll();
        return planificacao;
    }
    @PostMapping
    private Planificacao inserir(@RequestBody Planificacao planificacao){
        Planificacao planificacaoSalva = planificacaoRepository.save(planificacao);
        return planificacaoSalva;

    }

    @GetMapping("/{id}")
    public Planificacao buscar (@PathVariable Integer id){
        Optional<Planificacao> resultado = planificacaoRepository.findById(id);
        Planificacao avaliacoes = resultado.get();
        return avaliacoes;
    }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Planificacao excluir(@PathVariable Integer id){
        Optional<Planificacao> planificacao = planificacaoRepository.findById(id);
        planificacaoRepository.delete(planificacao.get());
        Planificacao planificacaoRetorno = planificacao.get();
        return planificacaoRetorno;
    }

    @PutMapping
    private Planificacao editar (@RequestBody Planificacao planificacao){
        Planificacao planificacaoEditada = planificacaoRepository.save(planificacao);
        return planificacaoEditada;
    }

}
