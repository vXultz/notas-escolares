package com.senai.projetonotas.service;

import com.senai.projetonotas.entity.MatriculaEntity;
import com.senai.projetonotas.entity.NotaEntity;
import com.senai.projetonotas.repository.NotaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class NotaService {

    private final NotaRepository repository;

    private final MatriculaService service;

    public NotaService(NotaRepository repository, MatriculaService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<NotaEntity> listarTodos() {
        log.info("todas as notas listadas");
        return repository.findAll();
    }

    public NotaEntity listarPorId(Long id) {
        log.info("nota com id {} buscada", id);
        return repository.findById(id).orElseThrow();

    }

    public NotaEntity buscarNotaPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }


    public BigDecimal calcularNota(BigDecimal coeficiente, BigDecimal nota) {
        return nota.multiply(coeficiente);
    }
}