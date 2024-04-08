package com.senai.projetonotas.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault(value = "0.00")
    @Column(nullable = false, columnDefinition = "NUMERIC(5,2)")
    private BigDecimal nota;

    @ColumnDefault(value = "0.000000")
    @Column(nullable = false, columnDefinition = "NUMERIC(19,6)")
    private BigDecimal coeficiente;

}
