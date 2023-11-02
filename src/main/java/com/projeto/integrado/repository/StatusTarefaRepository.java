package com.projeto.integrado.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projeto.integrado.model.StatusTarefa;

public interface StatusTarefaRepository extends CrudRepository<StatusTarefa, Long>{
    Optional<StatusTarefa> findByNome(String nome);

}
