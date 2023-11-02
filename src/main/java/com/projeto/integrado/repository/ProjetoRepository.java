package com.projeto.integrado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.integrado.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{
    List<Projeto> findByProjetoDescricaoContainingIgnoreCase(String descricao);
}
