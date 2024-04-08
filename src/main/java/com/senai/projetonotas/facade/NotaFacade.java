package com.senai.projetonotas.facade;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.entity.NotaEntity;
import com.senai.projetonotas.repository.NotaRepository;
import com.senai.projetonotas.service.MatriculaService;
import com.senai.projetonotas.service.NotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        log.info("removendo nota do aluno com o id {}", id);

        NotaEntity nota = service.buscarNotaPorId(id);
        MatriculaEntity matricula = matriculaService.buscarMatriculaPorId(nota.getMatricula().getId());

        BigDecimal notaMediaFinal = service.calcularNota(nota.getCoeficiente(), nota.getNota());

        matricula.setMediaFinal(matricula.getMediaFinal().subtract(notaMediaFinal));

        repository.delete(nota);
        matriculaService.atualizar(matricula.getId(), matricula);
    }


    public NotaEntity salvar(NotaEntity nota) {
        log.info("salvando nota da matricula com id {}", nota.getMatricula().getId());
        nota.setId(null);

        // adiciona a nova nota na matricula
        MatriculaEntity matricula = matriculaService.buscarMatriculaPorId(nota.getMatricula().getId());

        BigDecimal notaMediaFinal = service.calcularNota(nota.getCoeficiente(), nota.getNota());

        matricula.setMediaFinal(notaMediaFinal.add(matricula.getMediaFinal()));

        matriculaService.atualizar(matricula.getId(), matricula);

        //salva nova nota
        nota.setMatricula(matricula);
        nota.setProfessor(nota.getMatricula().getDisciplina().getProfessor());
        return repository.save(nota);
    }

    public NotaEntity atualizar(Long id, NotaEntity nota) {
        log.info("atualizando nota da matricula com o id {}", nota.getMatricula().getId());

        NotaEntity entity = service.buscarNotaPorId(id);
        MatriculaEntity matricula = matriculaService.buscarMatriculaPorId(nota.getMatricula().getId());

        //Atualiza media final da matricula
        BigDecimal notaAntiga = service.calcularNota(entity.getCoeficiente(), entity.getNota());

        BigDecimal notaAtualizada = service.calcularNota(nota.getCoeficiente(), nota.getNota());

        matricula.setMediaFinal(matricula.getMediaFinal().add(notaAtualizada.subtract(notaAntiga)));

        matriculaService.atualizar(matricula.getId(), matricula);

        //atualiza nota
        entity.setMatricula(matricula);
        entity.setProfessor(entity.getMatricula().getDisciplina().getProfessor());
        entity.setNota(nota.getNota());
        entity.setCoeficiente(nota.getCoeficiente());


        return repository.save(entity);
    }

    public List<NotaEntity> buscarNotaPorMatriculaId(Long id) {
        return service.buscarNotaPorMatriculaId(id);
    }
}
