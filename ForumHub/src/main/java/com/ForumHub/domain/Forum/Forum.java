package com.ForumHub.domain.Forum;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "forum")
@Entity(name = "forum")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private Date datadeCriacao = new Date();
    private boolean ativo = true;

    public void setDatadeCriacao(Date datadeCriacao) {
        this.datadeCriacao = datadeCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Forum(@Valid DadosCadastroForum dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }



    public Date getDatadeCriacao() {
        return datadeCriacao;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoForum dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
    }

}
