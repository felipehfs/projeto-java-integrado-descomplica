package com.projeto.integrado.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTarefaDTO(@NotBlank  String title, @NotBlank  String status, Integer projetoId) {
}
