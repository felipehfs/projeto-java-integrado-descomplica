package com.projeto.integrado.controller;

import java.util.List;

import com.projeto.integrado.dto.CreateTarefaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projeto.integrado.model.Tarefa;
import com.projeto.integrado.service.TarefaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RequestMapping("/tarefa")
@RestController
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;

    @GetMapping()
    public List<Tarefa> getByStatusNome(@RequestParam(name = "status")String nome) {
        return tarefaService.findByStatus(nome);
    }

    @Transactional
    @PostMapping()
    public Tarefa create(@RequestBody @Valid CreateTarefaDTO tarefa) {
        return tarefaService.create(tarefa);
    }
}
