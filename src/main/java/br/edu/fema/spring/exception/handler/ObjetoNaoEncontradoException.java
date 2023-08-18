package br.edu.fema.spring.exception.handler;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjetoNaoEncontradoException extends RuntimeException{
    public ObjetoNaoEncontradoException(String message) {
        super(message);
    }
}
