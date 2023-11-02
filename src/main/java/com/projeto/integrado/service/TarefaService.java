package com.projeto.integrado.service;

import java.util.List;

import com.projeto.integrado.dto.CreateTarefaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.integrado.model.StatusTarefa;
import com.projeto.integrado.model.Tarefa;
import com.projeto.integrado.repository.StatusTarefaRepository;
import com.projeto.integrado.repository.TarefaRepository;


@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private StatusTarefaRepository statusTarefaRepository;
   
    public Tarefa create(CreateTarefaDTO createTarefaDTO) {

        var statusTarefa = new StatusTarefa();
        statusTarefa.setNome(createTarefaDTO.status());
        statusTarefaRepository.save(statusTarefa);


        var projeto = projetoService.getById(createTarefaDTO.projetoId()).orElse(null);

        var tarefa = new Tarefa();
        tarefa.setTitle(createTarefaDTO.title());
        tarefa.setStatusTarefa(statusTarefa);

        if (projeto != null) {
            tarefa.setProjeto(projeto);
        }

        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findByStatus(String nome) {
        return this.tarefaRepository.findByStatusTarefaNomeContainingIgnoreCase(nome);
    }
}
