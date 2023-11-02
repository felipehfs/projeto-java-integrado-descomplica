package com.projeto.integrado.model;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "projeto_id")
	private Integer projetoId;

	@Column(name = "projeto_nome")
	private String projetoNome;

	@Column(name = "projeto_descricao")
	private String projetoDescricao;

	@Column(name = "projeto_inicio")
	private Instant projetoInicio;

	@Column(name = "projeto_fim")
	private Instant projetoFim;

	@Column(name = "projeto_status")
	private Boolean projetoStatus;

	@OneToMany(mappedBy = "projeto")
	private Set<Tarefa> tarefas;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "gerente_projeto",
		joinColumns = @JoinColumn(name = "projeto_id"),
		inverseJoinColumns = @JoinColumn(name = "recurso_id")
	)
	private Set<Recurso> gerentes;

	public Integer getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Integer projetoId) {
		this.projetoId = projetoId;
	}

	public String getProjetoNome() {
		return projetoNome;
	}

	public void setProjetoNome(String projetoNome) {
		this.projetoNome = projetoNome;
	}

	public String getProjetoDescricao() {
		return projetoDescricao;
	}

	public void setProjetoDescricao(String projetoDescricao) {
		this.projetoDescricao = projetoDescricao;
	}

	public Instant getProjetoInicio() {
		return projetoInicio;
	}

	public void setProjetoInicio(Instant projetoInicio) {
		this.projetoInicio = projetoInicio;
	}

	public Instant getProjetoFim() {
		return projetoFim;
	}

	public void setProjetoFim(Instant projetoFim) {
		this.projetoFim = projetoFim;
	}

	public Boolean getProjetoStatus() {
		return projetoStatus;
	}

	public void setProjetoStatus(Boolean projetoStatus) {
		this.projetoStatus = projetoStatus;
	}

	public void setGerentes(Set<Recurso> gerentes) {
		this.gerentes = gerentes;
	}

	public Set<Recurso> getGerentes() {
		return gerentes;
	}


	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Set<Tarefa> getTarefas() {
		return tarefas;
	}
}