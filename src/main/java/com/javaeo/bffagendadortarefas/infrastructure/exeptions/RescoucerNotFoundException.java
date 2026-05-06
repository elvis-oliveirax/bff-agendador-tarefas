package com.javaeo.bffagendadortarefas.infrastructure.exeptions;

public class RescoucerNotFoundException extends RuntimeException{

    public RescoucerNotFoundException(String mensagem){
		super(mensagem);
	}

	public RescoucerNotFoundException(String mensagem, Throwable throwable){
		super(mensagem, throwable);
	}
}
