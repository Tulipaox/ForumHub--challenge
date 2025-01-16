package com.ForumHub.domain.Forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record DadosCadastroForum(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        Date datadeCriacao
) {
}
