package com.projeto.integrado.dto;

import java.time.Instant;

import io.micrometer.common.lang.NonNull;

public record CreateProjetoDTO(@NonNull String projetoNome, @NonNull String projetoDescricao, @NonNull Instant projetoInicio, @NonNull Instant projetoFim) {
    
}
