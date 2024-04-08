package com.senai.projetonotas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "professor")
@Data
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
}
