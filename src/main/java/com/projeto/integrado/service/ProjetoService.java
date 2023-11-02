package com.projeto.integrado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.integrado.model.Projeto;
import com.projeto.integrado.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> getAll() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> getById(Integer id) {
        return projetoRepository.findById(id);
    }

    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto update(Integer id, Projeto projeto) {
        Projeto projetoAtualizado = projetoRepository.findById(id).orElse(null);

        if (projeto == null) {
            return null;
        }

        projetoAtualizado.setGerentes(projeto.getGerentes());
        projetoAtualizado.setProjetoDescricao(projeto.getProjetoDescricao());

        projetoAtualizado.setProjetoFim(projeto.getProjetoFim());
        projetoAtualizado.setProjetoInicio(projeto.getProjetoInicio());

        projetoAtualizado.setProjetoNome(projeto.getProjetoNome());
        projetoAtualizado.setProjetoStatus(projeto.getProjetoStatus());
        return projetoRepository.save(projetoAtualizado);
    }

    public boolean deleteProjeto(Integer id) {
        Projeto projeto = projetoRepository.findById(id).orElse(null);

        if (projeto == null) {
            return false;
        }
        
        projetoRepository.delete(projeto);
        return true;
    }

    public List<Projeto> findByProjetoDescricao(String descricao) {
        return projetoRepository.findByProjetoDescricaoContainingIgnoreCase(descricao);
    }
}
