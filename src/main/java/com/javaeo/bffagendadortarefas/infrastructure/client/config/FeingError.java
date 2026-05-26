package com.javaeo.bffagendadortarefas.infrastructure.client.config;

<<<<<<< HEAD
public class FeingError {
=======
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.BusinessException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.ConflictException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.RescoucerNotFoundException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeingError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){

        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributo já existente");
            case 403:
                return new RescoucerNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }

>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a
}
