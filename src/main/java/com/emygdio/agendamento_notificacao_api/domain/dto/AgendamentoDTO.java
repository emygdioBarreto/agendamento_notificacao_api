package com.emygdio.agendamento_notificacao_api.domain.dto;

import com.emygdio.agendamento_notificacao_api.domain.Enum.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record AgendamentoDTO (
    Long id,
    String emailDestinatario,
    String telefoneDestinatario,
    LocalDateTime dataHoraEnvio,
    LocalDateTime dataHoraAgendamento,
    LocalDateTime dataHoraModificacao,
    String mensagem,
    StatusNotificacaoEnum statusNotificacaoEnum) {
}
