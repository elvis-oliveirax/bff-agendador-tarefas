<<<<<<< HEAD
package com.javaeo.usuario.infrastructure.exeptions;

import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {
=======
package com.javaeo.bffagendadortarefas.infrastructure.exeptions;

public class UnauthorizedException extends RuntimeException {
>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable throwable) {super(message, throwable);}
}
