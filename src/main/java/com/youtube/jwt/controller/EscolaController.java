package com.youtube.jwt.controller;


import com.youtube.jwt.dao.EscolaRepository;
import com.youtube.jwt.entity.Avaliacoes;
import com.youtube.jwt.entity.Escola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired
    private EscolaRepository escolaRepository;
    @GetMapping("/listar")
    private List<Escola> listar(){
        List<Escola> escola = escolaRepository.findAll();
        return escola;
    }
    @PostMapping
    private Escola inserir(@RequestBody Escola escola){
        Escola escola1 = escolaRepository.save(escola);
        return escola1;
    }
    @GetMapping("/{id}")
    public Escola buscar (@PathVariable Integer id){
        Optional<Escola> resultado = escolaRepository.findById(id);
        Escola avaliacoes = resultado.get();
        return avaliacoes;
    }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Escola excluir(@PathVariable Integer id){
        Optional<Escola> escola = escolaRepository.findById(id);
        escolaRepository.delete(escola.get());
        Escola escolaRetorno = escola.get();
        return escolaRetorno;
    }

    @PutMapping
    private Escola editar (@RequestBody Escola escola){
        Escola escolaEditado = escolaRepository.save(escola);
        return escolaEditado;
    }
}
