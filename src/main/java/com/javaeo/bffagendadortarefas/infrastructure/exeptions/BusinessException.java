package com.javaeo.bffagendadortarefas.infrastructure.exeptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {super(message, throwable);}
}
