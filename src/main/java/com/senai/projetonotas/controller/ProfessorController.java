package com.senai.projetonotas.controller;


import com.senai.projetonotas.entity.ProfessorEntity;
import com.senai.projetonotas.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> listarTodos(){
        log.info("GET Professores -> listarTodos");
        List<ProfessorEntity> professores = professorService.listarTodos();
        log.info("200 OK");
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> listarPorId(@PathVariable Long id){
        log.info("GET Professores -> listarPorId");
        ProfessorEntity professor = professorService.listarPorId(id);
        log.info("200 OK");
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> salvar(@RequestBody ProfessorEntity professor){
        log.info("POST Professores -> salvar");
        ProfessorEntity professorSalvo = professorService.salvar(professor);
        log.info("201 CREATED");
        return new ResponseEntity<>(professorSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        log.info("DELETE Professores -> removerPorId");
        professorService.removerPorId(id);
        log.info("204 NO_CONTENT");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody ProfessorEntity professor){
        log.info("PUT Professor -> atualizar");
        professorService.atualizar(professor);
        log.info("200 OK");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
