package com.senai.projetonotas.facade;

import com.senai.projetonotas.entity.DisciplinaEntity;
import com.senai.projetonotas.repository.DisciplinaRepository;
import com.senai.projetonotas.service.DisciplinaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaFacade {

    private final DisciplinaService service;

    public DisciplinaFacade(DisciplinaService service) {
        this.service = service;
    }

    public List<DisciplinaEntity> listarTodos(){
       return service.listarTodos();
    }

    public DisciplinaEntity listarPorId(Long id){
        return service.listarPorId(id);
    }

    public DisciplinaEntity salvar(DisciplinaEntity disciplina) {
        return service.salvar(disciplina);
    }
    public void removerPorId(Long id) {
        service.removerPorId(id);
    }

    public int atualizar(DisciplinaEntity disciplina, Long id){
        return atualizar(disciplina,id);
    }
}
