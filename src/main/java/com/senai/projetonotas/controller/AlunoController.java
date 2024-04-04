package com.senai.projetonotas.controller;

import com.senai.projetonotas.entity.AlunoEntity;
import com.senai.projetonotas.service.AlunoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarTodos(){
        log.info("GET Alunos -> listarTodos");
        List<AlunoEntity> alunos = service.listarTodos();
        log.info("200 OK");
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> listarPorId(@PathVariable Long id){
        log.info("GET Alunos -> listarPorId");
        AlunoEntity aluno = service.listarPorId(id);
        log.info("200 OK");
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> salvar(@RequestBody AlunoEntity aluno){
        log.info("POST Alunos -> salvar");
        AlunoEntity alunoSalvo = service.salvar(aluno);
        log.info("201 CREATED");
        return new ResponseEntity<>(alunoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        log.info("DELETE Alunos -> removerPorId");
        service.removerPorId(id);
        log.info("204 NO_CONTENT");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody AlunoEntity aluno){
        log.info("PUT Alunos -> atualizar");
        service.atualizar(aluno);
        log.info("200 OK");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
