package com.ForumHub.infra.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ForumNaoEncontradoException extends RuntimeException {
    public ForumNaoEncontradoException(String message) {
        super(message);
    }
}