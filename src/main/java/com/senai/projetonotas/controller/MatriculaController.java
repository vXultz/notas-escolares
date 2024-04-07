package com.senai.projetonotas.controller;

import com.senai.projetonotas.dto.response.MediaGeralDto;
import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.facade.MatriculaFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaFacade facade;

    public MatriculaController(MatriculaFacade facade) {
        this.facade = facade;
    }


    @GetMapping
    public ResponseEntity<List<MatriculaEntity>> listarTodos() {
        log.info("GET Matriculas -> listarTodos");
        List<MatriculaEntity> matriculas = facade.listarTodos();
        log.info("200 OK");
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaEntity> listarPorId(@PathVariable Long id) {
        log.info("GET Matriculas -> listarPorId");
        MatriculaEntity matricula = facade.listarPorId(id);
        log.info("200 OK");
        return new ResponseEntity<>(matricula, HttpStatus.OK);
    }

    @GetMapping("aluno-id/{id}")
    public ResponseEntity<List<MatriculaEntity>> getAlunoId(@PathVariable Long id) {
        log.info("GET Matriculas/aluno-id -> buscarMatriculaPorAlunoId");
        List<MatriculaEntity> matriculas = facade.buscarMatriculaPorAlunoId(id);
        log.info("200 OK");
        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @GetMapping("disciplina-id/{id}")
    public ResponseEntity<List<MatriculaEntity>> getDisciplinaId(@PathVariable Long id) {
        log.info("GET Matriculas/disciplina-id -> buscarMatriculaPorDisciplinaId");
        List<MatriculaEntity> matriculas = facade.buscarMatriculaPorDisciplinaId(id);
        log.info("200 OK");
        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @GetMapping("media-geral")
    public ResponseEntity<MediaGeralDto> mediaGeral(@PathVariable Long id) {
        log.info("GET Matriculas/media-geral -> mediaGeral");
        MediaGeralDto mediaGeral = facade.buscarMediaGeral(id);
        log.info("200 OK");
        return ResponseEntity.status(HttpStatus.OK).body(mediaGeral);
    }

    @PostMapping
    public ResponseEntity<MatriculaEntity> salvar(@RequestBody MatriculaEntity matricula) {
        log.info("POST Matriculas -> salvar");
        MatriculaEntity matriculaSalva = facade.salvar(matricula);
        log.info("201 CREATED");
        return new ResponseEntity<>(matriculaSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        log.info("DELETE Matriculas -> removerPorId");
        facade.removerPorId(id);
        log.info("204 NO_CONTENT");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaEntity> atualizar(@PathVariable Long id, @RequestBody MatriculaEntity matricula) {
        log.info("PUT Matriculas -> atualizar");
        log.info("200 OK");
        return ResponseEntity.status(HttpStatus.OK).body(facade.atualizar(matricula, id));
    }
}
