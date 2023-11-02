package com.projeto.integrado.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateRecursoDTO(@NotBlank String nome, @NotEmpty Integer[] projectIds, Long tarefaId) {
    
}
