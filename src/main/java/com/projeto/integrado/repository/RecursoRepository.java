package com.projeto.integrado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.integrado.model.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, Integer>{
    List<Recurso> findByNomeContainingIgnoreCase(String nome);
}
