package com.senai.projetonotas.service;


import com.senai.projetonotas.entity.ProfessorEntity;
import com.senai.projetonotas.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;


    public List<ProfessorEntity> listarTodos(){
        log.info("todos os professores listados");
        return professorRepository.findAll();
    }

    public ProfessorEntity listarPorId(Long id){
        log.info("professor com id {} buscado", id);
        return professorRepository.findById(id).orElseThrow();

    }

    public ProfessorEntity salvar(ProfessorEntity professor) {
        log.info("salvando professor com o nome {}", professor.getNome());
        return professorRepository.save(professor);
    }
    public void removerPorId(Long id) {
        log.info("removendo professor com o id {}", id);
        professorRepository.deleteById(id);
    }

    public int atualizar(ProfessorEntity professor){
        log.info("atualizando professor com o id {}", professor.getId());
        return professorRepository.update(professor.getId(), professor.getNome());
    }
}
