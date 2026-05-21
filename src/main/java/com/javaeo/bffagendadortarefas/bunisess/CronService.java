package com.javaeo.bffagendadortarefas.bunisess;

import com.javaeo.bffagendadortarefas.bunisess.dto.in.LoginRequestDTO;
import com.javaeo.bffagendadortarefas.bunisess.dto.out.TarefasDTOResponse;
import com.javaeo.bffagendadortarefas.bunisess.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

   @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora(){
        String token = login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horasFuturasmaiscinco = LocalDateTime.now().plusHours(1);

        List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(horaAtual, horasFuturasmaiscinco, token);
        log.info("Tarefas encontradas: {}", listaTarefas);
        listaTarefas.forEach(tarefas -> {
            emailService.enviarEmail(tarefas);
            log.info("Email enviado: {}", tarefas.getEmailUsuario());
        tarefasService.alterarStatus(StatusNotificacaoEnum.NOTIFICADO, tarefas.getId(),
                token);
        });
        log.info("Finalizada a busca e notificação de tarefas");
    }

    public String login(LoginRequestDTO dto){
        return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO converterParaRequestDTO(){
        return LoginRequestDTO.builder()
            .email(email)
            .senha(senha)
            .build();

        }

    }
