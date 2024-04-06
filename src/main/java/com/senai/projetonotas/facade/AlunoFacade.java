package com.senai.projetonotas.facade;

import com.senai.projetonotas.entity.AlunoEntity;
import com.senai.projetonotas.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoFacade {
    
    private final AlunoService service;

    public AlunoFacade(AlunoService service) {
        this.service = service;
    }

    public List<AlunoEntity> listarTodos(){
       return service.listarTodos();
    }

    public AlunoEntity listarPorId(Long id){
        return service.listarPorId(id);
    }

    public AlunoEntity salvar(AlunoEntity aluno) {
        return service.salvar(aluno);
    }
    public void removerPorId(Long id) {
        service.removerPorId(id);
    }

    public int atualizar(AlunoEntity aluno, Long id){
        return atualizar(aluno,id);
    }
}
