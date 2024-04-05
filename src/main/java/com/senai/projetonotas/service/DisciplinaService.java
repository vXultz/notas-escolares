package com.senai.projetonotas.service;


import com.senai.projetonotas.entity.DisciplinaEntity;
import com.senai.projetonotas.repository.DisciplinaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaEntity> listarTodos(){
        log.info("todas as Disciplinas listadas");
        return disciplinaRepository.findAll();
    }

    public DisciplinaEntity listarPorId(Long id){
        log.info("disciplina com id {} buscado", id);
        return disciplinaRepository.findById(id).orElseThrow();

    }

    public DisciplinaEntity salvar(DisciplinaEntity disciplina) {
        log.info("salvando disciplina com o nome {}", disciplina.getNome());
        return disciplinaRepository.save(disciplina);
    }
    public void removerPorId(Long id) {
        log.info("removendo disciplina com o id {}", id);
        disciplinaRepository.deleteById(id);
    }

    public int atualizar(DisciplinaEntity disciplina){
        log.info("atualizando disciplina com o id {}", disciplina.getId());
        return disciplinaRepository.update(disciplina.getId(), disciplina.getNome());
    }
}
