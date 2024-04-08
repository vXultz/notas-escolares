package com.senai.projetonotas.repository;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {

    List<NotaEntity> findByMatriculaId(Long id);
}