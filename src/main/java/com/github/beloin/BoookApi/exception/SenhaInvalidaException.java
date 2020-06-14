package com.github.beloin.BoookApi.exception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha incorreta");
    }
}
