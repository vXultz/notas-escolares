package com.senai.projetonotas.controller;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.entity.NotaEntity;
import com.senai.projetonotas.facade.NotaFacade;
import com.senai.projetonotas.service.NotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaFacade facade;

    public NotaController(NotaFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<NotaEntity>> listarTodos() {
        log.info("GET Notas -> listarTodos");
        List<NotaEntity> notas = facade.listarTodos();
        log.info("200 OK");
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaEntity> listarPorId(@PathVariable Long id) {
        log.info("GET Notas -> listarPorId");
        NotaEntity nota = facade.listarPorId(id);
        log.info("200 OK");
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NotaEntity> salvar(@RequestBody NotaEntity nota) {
        log.info("POST Notas -> salvar");
        NotaEntity notaSalva = facade.salvar(nota);
        log.info("201 CREATED");
        return new ResponseEntity<>(notaSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        log.info("DELETE Notas -> removerPorId");
        facade.removerPorId(id);
        log.info("204 NO_CONTENT");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaEntity> atualizar(@PathVariable Long id, @RequestBody NotaEntity nota) {
        log.info("PUT Notas -> atualizar");
        log.info("200 OK");
        return ResponseEntity.status(HttpStatus.OK).body(facade.atualizar(id, nota));
    }
}