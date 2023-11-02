package com.projeto.integrado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tarefa_id")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "statusTarefa", referencedColumnName = "id")
    private StatusTarefa statusTarefa;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto", referencedColumnName = "projeto_id")
    private Projeto projeto;

    @OneToOne
    @JoinColumn(name = "recurso", referencedColumnName = "recurso_id")
    private Recurso recurso;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public void setStatusTarefa(StatusTarefa statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public StatusTarefa getStatusTarefa() {
        return statusTarefa;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
