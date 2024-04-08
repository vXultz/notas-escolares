package com.senai.projetonotas.facade;

import com.senai.projetonotas.entity.ProfessorEntity;
import com.senai.projetonotas.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorFacade {
    
    private final ProfessorService service;

    public ProfessorFacade(ProfessorService service) {
        this.service = service;
    }

    public List<ProfessorEntity> listarTodos(){
       return service.listarTodos();
    }

    public ProfessorEntity listarPorId(Long id){
        return service.listarPorId(id);
    }

    public ProfessorEntity salvar(ProfessorEntity professor) {
        return service.salvar(professor);
    }
    public void removerPorId(Long id) {
        service.removerPorId(id);
    }

    public int atualizar(ProfessorEntity professor, Long id){
        return atualizar(professor,id);
    }
}
