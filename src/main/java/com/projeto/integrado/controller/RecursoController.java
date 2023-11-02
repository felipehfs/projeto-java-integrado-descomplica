package com.projeto.integrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.integrado.dto.CreateRecursoDTO;
import com.projeto.integrado.model.Recurso;
import com.projeto.integrado.service.RecursoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @Transactional
    @PostMapping
    public Recurso create(@RequestBody @Valid CreateRecursoDTO createRecursoDTO) {
        return recursoService.create(createRecursoDTO);
    }

    @GetMapping
    public List<Recurso> getByName(@RequestParam(name = "nome", required = false) String nome) {
        if (nome == null) {
            return recursoService.getAll();
        }

        return recursoService.getByNome(nome);
    }
}
