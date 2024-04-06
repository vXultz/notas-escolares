package com.senai.projetonotas.facade;

import com.senai.projetonotas.entity.NotaEntity;
import com.senai.projetonotas.repository.NotaRepository;
import com.senai.projetonotas.service.MatriculaService;
import com.senai.projetonotas.service.NotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NotaFacade {
    
    private final NotaService service;

    private final NotaRepository repository;

    private final MatriculaService matriculaService;

    public NotaFacade(NotaService service, NotaRepository repository, MatriculaService matriculaService) {
        this.service = service;
        this.repository = repository;
        this.matriculaService = matriculaService;
    }

    public List<NotaEntity> listarTodos(){
       return service.listarTodos();
    }

    public NotaEntity listarPorId(Long id){
        return service.listarPorId(id);
    }

    public void removerPorId(Long id) {
        service.removerPorId(id);
    }

    public NotaEntity atualizar(NotaEntity nota, Long id){
        return atualizar(nota,id);
    }

    public NotaEntity salvar(NotaEntity nota) {
        log.info("salvando nota da matricula com id {}", nota.getMatricula().getId());

        nota.setId(null);
        nota.setMatricula(matriculaService.buscarMatriculaPorId(nota.getMatricula().getId()));
        nota.setProfessor(nota.getMatricula().getDisciplina().getProfessor());
        return repository.save(nota);
    }

    public NotaEntity atualizar(Long id, NotaEntity nota) {
        log.info("atualizando nota da matricula com o id {}", nota.getMatricula().getId());

        NotaEntity entity = service.buscarNotaPorId(id);
        entity.setMatricula(matriculaService.buscarMatriculaPorId(nota.getMatricula().getId()));
        entity.setProfessor(entity.getMatricula().getDisciplina().getProfessor());
        entity.setNota(nota.getNota());
        entity.setCoeficiente(nota.getCoeficiente());
        return repository.save(entity);
    }
}
