package com.senai.projetonotas.repository;

import com.senai.projetonotas.entity.DisciplinaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Disciplina SET nome = :nome, WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("nome") String nome
    );
}
