package com.ForumHub.domain.Forum;

import java.util.Date;

public record DadosDetalhamentoForum(Long id, String titulo, String mensagem, Date datadeCriacao) {

    public DadosDetalhamentoForum(Forum forum){
        this(forum.getId(), forum.getTitulo(), forum.getMensagem(), forum.getDatadeCriacao());
    }

}
