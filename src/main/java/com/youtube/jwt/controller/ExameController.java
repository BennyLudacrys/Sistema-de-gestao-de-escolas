package com.youtube.jwt.controller;


import com.youtube.jwt.dao.ExameRepository;
import com.youtube.jwt.entity.Avaliacoes;
import com.youtube.jwt.entity.Exame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exame")
public class ExameController {
    @Autowired
    private ExameRepository exameRepository;
    @GetMapping("/listar")
    private List<Exame> listar(){
        List<Exame> exames = exameRepository.findAll();
        return exames;
    }
    @PostMapping
    private Exame inserir(@RequestBody Exame exame){
        Exame exame1 = exameRepository.save(exame);
        return exame1;

    }
    @GetMapping("/{id}")
    public Exame buscar (@PathVariable Integer id){
        Optional<Exame> resultado = exameRepository.findById(id);
        Exame exame = resultado.get();
        return exame;
    }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Exame excluir(@PathVariable Integer id){
        Optional<Exame> exame = exameRepository.findById(id);
        exameRepository.delete(exame.get());
        Exame exameRetorno = exame.get();
        return exameRetorno;
    }

    @PutMapping
    private Exame editar (@RequestBody Exame administrador){
        Exame administradorEditado = exameRepository.save(administrador);
        return administradorEditado;
    }
}
