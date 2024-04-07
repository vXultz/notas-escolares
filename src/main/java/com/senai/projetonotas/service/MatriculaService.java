package com.senai.projetonotas.service;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.repository.MatriculaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.senai.projetonotas.exception.error.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MatriculaService {

    private final MatriculaRepository repository;

    public MatriculaService(MatriculaRepository repository) {
        this.repository = repository;
    }

    public List<MatriculaEntity> listarTodos() {
        log.info("todos os alunos listados");
        return repository.findAll();
    }

    public MatriculaEntity listarPorId(Long id) {
        log.info("aluno com id {} buscado", id);
        return repository.findById(id).orElseThrow();

    }

    public MatriculaEntity buscarMatriculaPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<MatriculaEntity> buscarMatriculaPorAlunoId(Long id) {
        List<MatriculaEntity> matriculas = repository.findByAlunoId(id);
        if (matriculas.isEmpty()) {
            throw new NotFoundException("Nenhuma matricula com este ID de aluno encontrada");
        }
        return matriculas;
    }

    public List<MatriculaEntity> buscarMatriculaPorDisciplinaId(Long id) {
        List<MatriculaEntity> matriculas = repository.findByDisciplinaId(id);
        if (matriculas.isEmpty()) {
            throw new NotFoundException("Nenhuma matricula com este ID de disciplina encontrada");
        }
        return matriculas;
    }

    public MatriculaEntity salvar(MatriculaEntity matricula) {
        log.info("salvando matricula do aluno com nome {}", matricula.getAluno().getNome());
        matricula.setId(null);
        return repository.save(matricula);
    }



    public MatriculaEntity atualizar(Long id, MatriculaEntity matricula) {
        log.info("atualizando matricula do aluno com o id {}", matricula.getAluno().getId());
        MatriculaEntity entity = buscarMatriculaPorId(id);
        entity.setAluno(matricula.getAluno());
        entity.setDisciplina(matricula.getDisciplina());
        entity.setMediaFinal(matricula.getMediaFinal());
        return repository.save(entity);
    }
}
