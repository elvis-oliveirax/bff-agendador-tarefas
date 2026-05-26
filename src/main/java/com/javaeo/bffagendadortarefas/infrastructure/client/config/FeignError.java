package com.javaeo.bffagendadortarefas.infrastructure.client.config;

import com.javaeo.bffagendadortarefas.infrastructure.exeptions.BusinessException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.ConflictException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.RescoucerNotFoundException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){

        String mensagemErro = mensagemError(response);

		switch (response.status()){
            case 409:
                return new ConflictException("Erro: " + mensagemErro);
            case 403:
                return new RescoucerNotFoundException("Erro: " + mensagemErro);
            case 401:
                return new UnauthorizedException("Erro: " + mensagemErro);
            case 400:
                return new BadRequestException("Erro: " + mensagemErro);
            default:
                return new BusinessException("Erro: " + mensagemErro);
        }
    }

     private String mensagemError(Response response){
         try {
             if(Objects.isNull(response.body())){
                 return "";
             }
             return new String (response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

}
