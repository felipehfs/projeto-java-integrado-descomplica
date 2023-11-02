package com.projeto.integrado.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recurso")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recurso_id")
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "gerentes", cascade = CascadeType.PERSIST)
    private Set<Projeto> projetos;

    @OneToOne(mappedBy = "recurso")
    private Tarefa tarefa;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setProjetos(Set<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Set<Projeto> getProjetos() {
        return projetos;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
