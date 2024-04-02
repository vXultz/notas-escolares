package com.senai.projetonotas.service;

import com.senai.projetonotas.entity.AlunoEntity;
import com.senai.projetonotas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository repository;

    public List<AlunoEntity> listarTodos(){
        return repository.findAll();
    }

    public Optional<AlunoEntity> listarPorId(Long id){
        return repository.findById(id);
    }

    public AlunoEntity salvar(AlunoEntity aluno) {
        return repository.save(aluno);
    }
    public void removerPorId(Long id) {
        repository.deleteById(id);
    }

    public int atualizar(AlunoEntity aluno){
        return repository.update(aluno.getId(), aluno.getNome(), aluno.getDataNascimento());
    }
}
