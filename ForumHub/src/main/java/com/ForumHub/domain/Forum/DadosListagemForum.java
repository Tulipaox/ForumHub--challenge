package com.ForumHub.domain.Forum;

import java.util.Date;

public record DadosListagemForum(
                                 Long id,
                                 String titulo,
                                 String mensagem,
                                 Date datadeCriacao) {

    public  DadosListagemForum(Forum forum){
        this(forum.getId(), forum.getTitulo(), forum.getMensagem(), forum.getDatadeCriacao());
    }
}
