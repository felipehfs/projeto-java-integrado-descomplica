package com.projeto.integrado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "statusTarefa")
public class StatusTarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_tarefa_id")
    private Integer id;

    private String nome;

    @OneToOne(mappedBy = "statusTarefa")
    private Tarefa tarefa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}