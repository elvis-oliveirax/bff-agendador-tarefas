<<<<<<< HEAD
package com.javaeo.usuario.infrastructure.exeptions;
=======
package com.javaeo.bffagendadortarefas.infrastructure.exeptions;
>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a

public class ConflictException extends RuntimeException{

    public ConflictException(String mensagem){
        super(mensagem);
    }

    public ConflictException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
