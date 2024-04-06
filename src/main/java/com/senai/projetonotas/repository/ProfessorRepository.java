package com.senai.projetonotas.repository;

import com.senai.projetonotas.entity.ProfessorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessorRepository extends JpaRepository <ProfessorEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Professor SET nome = :nome WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("nome") String nome
    );
}
