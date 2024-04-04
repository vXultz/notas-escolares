package com.senai.projetonotas.repository;

import com.senai.projetonotas.entity.AlunoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Aluno SET nome = :nome, data_nascimento = :dataNascimento  WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("nome") String nome,
               @Param("dataNascimento") String dataNascimento
    );
}
