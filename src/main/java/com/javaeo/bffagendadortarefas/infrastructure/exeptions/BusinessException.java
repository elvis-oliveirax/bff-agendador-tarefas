package com.javaeo.bffagendadortarefas.infrastructure.exeptions;

<<<<<<< HEAD
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable throwable) {super(message, throwable);}
=======
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {super(message, throwable);}
>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a
}
