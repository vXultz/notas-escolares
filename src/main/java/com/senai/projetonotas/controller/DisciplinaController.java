package com.senai.projetonotas.controller;


import com.senai.projetonotas.entity.DisciplinaEntity;
import com.senai.projetonotas.service.DisciplinaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> listarTodos(){
        log.info("GET Disciplinas -> listarTodos");
        List<DisciplinaEntity> disciplinas = disciplinaService.listarTodos();
        log.info("200 OK");
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> listarPorId(@PathVariable Long id){
        log.info("GET Disciplinas -> listarPorId");
        DisciplinaEntity disciplina = disciplinaService.listarPorId(id);
        log.info("200 OK");
        return new ResponseEntity<>(disciplina, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DisciplinaEntity> salvar(@RequestBody DisciplinaEntity disciplina){
        log.info("POST Disciplina -> salvar");
        DisciplinaEntity disciplinaSalva = disciplinaService.salvar(disciplina);
        log.info("201 CREATED");
        return new ResponseEntity<>(disciplinaSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        log.info("DELETE Disciplina -> removerPorId");
        disciplinaService.removerPorId(id);
        log.info("204 NO_CONTENT");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody DisciplinaEntity disciplina){
        log.info("PUT Professor -> atualizar");
        disciplinaService.atualizar(disciplina);
        log.info("200 OK");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
