package com.projeto.integrado.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.integrado.dto.CreateRecursoDTO;
import com.projeto.integrado.model.Projeto;
import com.projeto.integrado.model.Recurso;
import com.projeto.integrado.repository.ProjetoRepository;
import com.projeto.integrado.repository.RecursoRepository;
import com.projeto.integrado.repository.TarefaRepository;

@Service
public class RecursoService {
    
    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Recurso> getAll() {
        return recursoRepository.findAll();
    }

    public Recurso create(CreateRecursoDTO createRecursoDTO) {
        var recurso = new Recurso();
        recurso.setNome(createRecursoDTO.nome());

        
        if (createRecursoDTO.projectIds() != null &&createRecursoDTO.projectIds().length > 0) {
            var projectIds = List.of(createRecursoDTO.projectIds());
            var projects = projetoRepository.findAllById(projectIds);
            Set<Projeto> projectSet = new HashSet<>();
            projectSet.addAll(projects);
            recurso.setProjetos(projectSet);
        }

        if (createRecursoDTO.tarefaId() != null) {
            var tarefa = tarefaRepository.findById(createRecursoDTO.tarefaId()).orElse(null);
            if (tarefa != null)recurso.setTarefa(tarefa);
        }

        recursoRepository.save(recurso);

        return recurso;
    }

    public List<Recurso> getByNome(String nome) {
        return recursoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
