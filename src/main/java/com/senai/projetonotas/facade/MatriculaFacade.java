package com.senai.projetonotas.facade;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.entity.NotaEntity;
import com.senai.projetonotas.repository.MatriculaRepository;
import com.senai.projetonotas.service.MatriculaService;
import com.senai.projetonotas.service.NotaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MatriculaFacade {
    
    private final MatriculaService service;

    private final MatriculaRepository repository;

    private final NotaService notaService;

    public MatriculaFacade(MatriculaService service, MatriculaRepository repository, NotaService notaService) {
        this.service = service;
        this.repository = repository;
        this.notaService = notaService;
    }

    public List<MatriculaEntity> listarTodos(){
       return service.listarTodos();
    }

    public MatriculaEntity listarPorId(Long id){
        return service.listarPorId(id);
    }

    public MatriculaEntity salvar(MatriculaEntity matricula) {
        return service.salvar(matricula);
    }

    public void removerPorId(Long id) {
        MatriculaEntity matricula = service.listarPorId(id);
        List<NotaEntity> listaNotas = notaService.listarTodos();

        for (NotaEntity nota : listaNotas){
            if (Objects.equals(nota.getMatricula(), matricula)){
                throw new RuntimeException("Não é possivel deletar uma Matricula com nota vinculada");
            }
        }
        repository.deleteById(id);
    }

    public MatriculaEntity atualizar(MatriculaEntity matricula, Long id){
        return atualizar(matricula,id);
    }

    public List<MatriculaEntity> buscarMatriculaPorAlunoId(Long id) {
        return service.buscarMatriculaPorAlunoId(id);
    }

    public List<MatriculaEntity> buscarMatriculaPorDisciplinaId(Long id) {
        return service.buscarMatriculaPorDisciplinaId(id);
    }
}
