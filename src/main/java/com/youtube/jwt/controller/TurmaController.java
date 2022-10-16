package com.youtube.jwt.controller;

import com.youtube.jwt.dao.TurmaRepository;
import com.youtube.jwt.entity.Avaliacoes;
import com.youtube.jwt.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("turma")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;
    @GetMapping("/listar")
    public List<Turma> listar(){
        List<Turma> turmas = turmaRepository.findAll();
        return turmas;
    }
    @PostMapping
    public Turma inserir (@RequestBody Turma turma){
        Turma turmaSalva = turmaRepository.save(turma);
        return turmaSalva;
    }

    @GetMapping("/{id}")
    public Turma buscar (@PathVariable Integer id){
        Optional<Turma> resultado = turmaRepository.findById(id);
        Turma turma = resultado.get();
        return turma;
    }

    @DeleteMapping("/{id}")
    //Pathvariable e para cobinar o codigo do mapeamento com o objecto criado
    private Turma excluir(@PathVariable Integer id){
        Optional<Turma> turma = turmaRepository.findById(id);
        turmaRepository.delete(turma.get());
        Turma turmaRetorno = turma.get();
        return turmaRetorno;
    }

    @PutMapping
    private Turma editar (@RequestBody Turma turma){
        Turma turmaEditada = turmaRepository.save(turma);
        return turmaEditada;
    }
}
