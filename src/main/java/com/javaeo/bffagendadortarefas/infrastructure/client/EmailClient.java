package com.javaeo.bffagendadortarefas.infrastructure.client;


import com.javaeo.bffagendadortarefas.bunisess.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

	@PostMapping("/email")
	void enviarEmail(@RequestBody TarefasDTOResponse dto);
}
