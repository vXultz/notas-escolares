package com.senai.projetonotas.service;

import com.senai.projetonotas.entity.AlunoEntity;
import com.senai.projetonotas.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<AlunoEntity> listarTodos(){
        log.info("todos os alunos listados");
        return repository.findAll();
    }

    public AlunoEntity listarPorId(Long id){
        log.info("aluno com id {} buscado", id);
        return repository.findById(id).orElseThrow();

    }

    public AlunoEntity salvar(AlunoEntity aluno) {
        log.info("salvando aluno com o nome {}", aluno.getNome());
        return repository.save(aluno);
    }
    public void removerPorId(Long id) {
        log.info("removendo aluno com o id {}", id);
        repository.deleteById(id);
    }

    public int atualizar(AlunoEntity aluno){
        log.info("atualizando aluno com o id {}", aluno.getId());
        return repository.update(aluno.getId(), aluno.getNome(), aluno.getDataNascimento());
    }
}
