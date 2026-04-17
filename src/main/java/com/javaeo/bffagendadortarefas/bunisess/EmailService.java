package com.javaeo.bffagendadortarefas.bunisess;


import com.javaeo.bffagendadortarefas.bunisess.dto.out.TarefasDTOResponse;
import com.javaeo.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

	private final EmailClient emailClient;

	public void enviarEmail(TarefasDTOResponse dto) {
		emailClient.enviarEmail(dto);

	}
}
