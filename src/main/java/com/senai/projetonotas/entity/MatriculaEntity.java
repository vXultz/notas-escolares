package com.senai.projetonotas.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "matricula")
@Data
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaEntity disciplina;

    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Column( columnDefinition = "TIMESTAMP")
    private LocalDateTime dataMatricula = LocalDateTime.now();


    @ColumnDefault(value = "0.00")
    @Column( columnDefinition = "NUMERIC(5,2)")
    private BigDecimal mediaFinal = BigDecimal.valueOf(0.00);
}
