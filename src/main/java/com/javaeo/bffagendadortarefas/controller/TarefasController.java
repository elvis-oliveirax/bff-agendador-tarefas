package com.javaeo.bffagendadortarefas.controller;


import com.javaeo.bffagendadortarefas.bunisess.TarefasService;
import com.javaeo.bffagendadortarefas.bunisess.dto.in.TarefasDTORequest;
import com.javaeo.bffagendadortarefas.bunisess.dto.out.TarefasDTOResponse;
import com.javaeo.bffagendadortarefas.bunisess.enums.StatusNotificacaoEnum;
import com.javaeo.bffagendadortarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SHEME)
public class TarefasController {

	private final TarefasService tarefasService;

	@PostMapping
	@Operation(summary = "Salvar Tarefas de Usuário",
			description = "Cria um nova tarefas")
	@ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
	@ApiResponse(responseCode = "500", description = "Erro de servidor")
	public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
	                                                        @RequestHeader(value = "Authorization", required = false) String token) {

		return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
	}

	@GetMapping("/eventos")
	@Operation(summary = "Busca tarefas por Periodo",
			description = "Busca tarefas cadastrada por periodos")
	@ApiResponse(responseCode = "200", description = "Tarefas encontrada")
	@ApiResponse(responseCode = "500", description = "Erro de servidor")
	public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
			@RequestHeader(name = "Authorization", required = false) String token) {

		return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
	}

	@GetMapping
	@Operation(summary = "Busca lista de tarefas por email de usuário",
			description = "Busca tarefas cadastrada por usuário")
	@ApiResponse(responseCode = "200", description = "Tarefas encontrada")
	@ApiResponse(responseCode = "500", description = "Erro de servidor")
	public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {
		List<TarefasDTOResponse> tarefas = tarefasService.buscaTarefasPorEmail(token);
		return ResponseEntity.ok(tarefas);

	}

	@DeleteMapping
	@Operation(summary = "Deleta Tarefas por Id", description = "Deleta tarefas cadastrada por ID")
	@ApiResponse(responseCode = "200", description = "Tarefas deletadas")
	@ApiResponse(responseCode = "500", description = "Erro de servidor")
	public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
												  @RequestHeader(name = "Authorization", required = false) String token) {

		tarefasService.deletaTarefaPorID(id, token);

		return ResponseEntity.ok().build();
	}

	@PatchMapping
	@Operation(summary = "Altera status de Tarefas ", description = "Altera status de tarefas cadastrada")
	@ApiResponse(responseCode = "200", description = "Status da tarefa alterado")
	@ApiResponse(responseCode = "500", description = "Erro de servidor")
	public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
	                                                                  @RequestParam("id") String id,
	                                                                  @RequestHeader(name = "Authorization", required = false) String token) {
		return ResponseEntity.ok(tarefasService.alterarStatus(status, id, token));
	}

	@PutMapping
	@Operation(summary = "Altera dados de Tarefas ", description = "Altera dados de tarefas cadastrada")
	@ApiResponse(responseCode = "200", description = "Tarefas alteradas")
	@ApiResponse(responseCode = "500", description = "Erro de servidor")
	public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
	                                                        @RequestParam("id") String id,
	                                                        @RequestHeader(name = "Authorization", required = false) String token) {
		return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
	}

}
