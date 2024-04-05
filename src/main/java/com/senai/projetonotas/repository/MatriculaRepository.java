package com.senai.projetonotas.repository;

import com.senai.projetonotas.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long> {

    List<MatriculaEntity> findByAlunoId(Long id);

    List<MatriculaEntity> findByDisciplinaId(Long id);
}
