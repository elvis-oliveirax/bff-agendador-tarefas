<<<<<<< HEAD
package com.javaeo.usuario.infrastructure.exeptions;
=======
package com.javaeo.bffagendadortarefas.infrastructure.exeptions;
>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a

public class RescoucerNotFoundException extends RuntimeException{

    public RescoucerNotFoundException(String mensagem){
		super(mensagem);
	}

	public RescoucerNotFoundException(String mensagem, Throwable throwable){
		super(mensagem, throwable);
	}
}
