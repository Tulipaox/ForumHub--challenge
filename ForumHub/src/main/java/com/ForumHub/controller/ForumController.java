package com.ForumHub.controller;

import com.ForumHub.domain.Forum.*;
import com.ForumHub.infra.exeption.ForumNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@RestController
@RequestMapping("topicos")
public class ForumController {

    @Autowired
    private ForumRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroForum dados, UriComponentsBuilder uriBuilder) {
        var forum = new Forum(dados);
        repository.save(forum);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(forum.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoForum(forum));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemForum>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemForum::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("update")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoForum dados) {
        var forum = repository.findById(dados.id())
                .orElseThrow(() -> new ForumNaoEncontradoException("Fórum não encontrado"));

        forum.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoForum(forum));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var forum = repository.getReferenceById(id);
        repository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var forum = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoForum(forum));
    }

}