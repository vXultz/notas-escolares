package com.senai.projetonotas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "notas")
@Data
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula_id", nullable = false)
    private MatriculaEntity matricula;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorEntity professor;

    @Column(nullable = false, columnDefinition = "NUMERIC(5,2) DEFAULT '0.00'")
    private BigDecimal nota;

    @Column(nullable = false, columnDefinition = "NUMERIC(19,6) DEFAULT '0.00'")
    private BigDecimal coeficiente;

}
