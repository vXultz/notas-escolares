package com.senai.projetonotas.service;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.entity.NotaEntity;
import com.senai.projetonotas.repository.NotaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NotaService {

    private final NotaRepository repository;

    private final MatriculaService service;

    public NotaService(NotaRepository repository, MatriculaService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<NotaEntity> listarTodos() {
        log.info("todas as notas listadas");
        return repository.findAll();
    }

    public NotaEntity listarPorId(Long id) {
        log.info("nota com id {} buscada", id);
        return repository.findById(id).orElseThrow();

    }

    public NotaEntity buscarNotaPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }


    public NotaEntity salvar(NotaEntity nota) {
        log.info("salvando nota da matricula com id {}", nota.getMatricula().getId());

        nota.setId(null);
        nota.setMatricula(service.buscarMatriculaPorId(nota.getMatricula().getId()));
        nota.setProfessor(nota.getMatricula().getDisciplina().getProfessor());
        return repository.save(nota);
    }

    public void removerPorId(Long id) {
        log.info("removendo nota do aluno com o id {}", id);
        repository.deleteById(id);
    }

    public NotaEntity atualizar(Long id, NotaEntity nota) {
        log.info("atualizando nota da matricula com o id {}", nota.getMatricula().getId());

        NotaEntity entity = buscarNotaPorId(id);
        entity.setMatricula(service.buscarMatriculaPorId(nota.getMatricula().getId()));
        entity.setProfessor(entity.getMatricula().getDisciplina().getProfessor());
        entity.setNota(nota.getNota());
        entity.setCoeficiente(nota.getCoeficiente());
        return repository.save(entity);
    }
}