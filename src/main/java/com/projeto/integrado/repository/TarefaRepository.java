package com.projeto.integrado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.integrado.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{
}
