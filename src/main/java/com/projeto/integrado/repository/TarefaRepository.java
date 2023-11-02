package com.projeto.integrado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.integrado.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    List<Tarefa> findByStatusTarefaNomeContainingIgnoreCase(String nome);
}
