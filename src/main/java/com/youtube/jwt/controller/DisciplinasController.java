package com.youtube.jwt.controller;


import com.youtube.jwt.dao.DisciplinasRepository;
import com.youtube.jwt.entity.Avaliacoes;
import com.youtube.jwt.entity.Disciplinas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinasController {

    @Autowired
    private DisciplinasRepository disciplinasRepository;
    @GetMapping("/listar")
    private List<Disciplinas> listar(){
        List<Disciplinas> disciplinas = disciplinasRepository.findAll();
        return disciplinas;
    }
    @PostMapping
    private Disciplinas inserir(@RequestBody Disciplinas disciplina){
        Disciplinas disciplinas = disciplinasRepository.save(disciplina);
        return disciplinas;

    }
    @GetMapping("/{id}")
    public Disciplinas buscar (@PathVariable Integer id){
        Optional<Disciplinas> resultado = disciplinasRepository.findById(id);
        Disciplinas disciplina = resultado.get();
        return disciplina;
    }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Disciplinas excluir(@PathVariable Integer id){
        Optional<Disciplinas> disciplina = disciplinasRepository.findById(id);
        disciplinasRepository.delete(disciplina.get());
        Disciplinas disciplinaRetorno = disciplina.get();
        return disciplinaRetorno;
    }

    @PutMapping
    private Disciplinas editar (@RequestBody Disciplinas disciplina){
        Disciplinas disciplinaEditada = disciplinasRepository.save(disciplina);
        return disciplinaEditada;
    }

}
