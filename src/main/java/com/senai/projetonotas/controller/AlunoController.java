package com.senai.projetonotas.controller;

import com.senai.projetonotas.entity.AlunoEntity;
import com.senai.projetonotas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarTodos(){
        List<AlunoEntity> alunos = service.listarTodos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> listarPorId(@PathVariable Long id){
        Optional<AlunoEntity> aluno = service.listarPorId(id);
        if (aluno.isPresent()){
            return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> salvar(@RequestBody AlunoEntity aluno){
        AlunoEntity alunoSalvo = service.salvar(aluno);
        return new ResponseEntity<>(alunoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        service.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody AlunoEntity aluno){
        service.atualizar(aluno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
