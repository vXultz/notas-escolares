package com.senai.projetonotas.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "disciplina")
@Data
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorEntity professor;
}
