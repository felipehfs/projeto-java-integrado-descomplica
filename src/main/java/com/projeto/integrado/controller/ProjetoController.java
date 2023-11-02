package com.projeto.integrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.integrado.dto.CreateProjetoDTO;
import com.projeto.integrado.model.Projeto;
import com.projeto.integrado.service.ProjetoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
   
    @Autowired
    private ProjetoService projetoService;


    @GetMapping
    public List<Projeto> getByProjetoDescicao(@RequestParam(name = "descricao", required = false) String descricao) {
        if (descricao == null) {
            return projetoService.getAll();
        }
        return projetoService.findByProjetoDescricao(descricao);
    }

    @Transactional
    @PostMapping
    public Projeto create(@RequestBody @Valid CreateProjetoDTO createProjetoDTO) {

        Projeto projeto = new Projeto();
        projeto.setProjetoNome(createProjetoDTO.projetoNome());        
        projeto.setProjetoDescricao(createProjetoDTO.projetoDescricao());
        projeto.setProjetoInicio(createProjetoDTO.projetoInicio());        
        projeto.setProjetoFim(createProjetoDTO.projetoFim());

        return projetoService.saveProjeto(projeto);

    }
}
