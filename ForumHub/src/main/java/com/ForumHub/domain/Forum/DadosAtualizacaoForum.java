package com.ForumHub.domain.Forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAtualizacaoForum(

        @NotNull
        Long id,
        String titulo,
        String mensagem,
        Date datadeCriacao
) {
}
