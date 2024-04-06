package com.senai.projetonotas.controller;


import com.senai.projetonotas.entity.DisciplinaEntity;
import com.senai.projetonotas.facade.DisciplinaFacade;
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

    private final DisciplinaFacade facade;

    public DisciplinaController(DisciplinaFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> listarTodos(){
        log.info("GET Disciplinas -> listarTodos");
        List<DisciplinaEntity> disciplinas = facade.listarTodos();
        log.info("200 OK");
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> listarPorId(@PathVariable Long id){
        log.info("GET Disciplinas -> listarPorId");
        DisciplinaEntity disciplina = facade.listarPorId(id);
        log.info("200 OK");
        return new ResponseEntity<>(disciplina, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DisciplinaEntity> salvar(@RequestBody DisciplinaEntity disciplina){
        log.info("POST Disciplina -> salvar");
        DisciplinaEntity disciplinaSalva = facade.salvar(disciplina);
        log.info("201 CREATED");
        return new ResponseEntity<>(disciplinaSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        log.info("DELETE Disciplina -> removerPorId");
        facade.removerPorId(id);
        log.info("204 NO_CONTENT");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody DisciplinaEntity disciplina){
        log.info("PUT Professor -> atualizar");
        facade.atualizar(disciplina, id);
        log.info("200 OK");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
