package com.emygdio.agendamento_notificacao_api.domain.dto;

import com.emygdio.agendamento_notificacao_api.domain.Enum.StatusNotificacaoEnum;

import java.time.LocalDateTime;
import java.util.Date;

public record AgendamentoDTO (
    Long id,
    String emailDestinatario,
    String telefoneDestinatario,
    Date dataHoraEnvio,
    Date dataHoraAgendamento,
    Date dataHoraModificacao,
    String mensagem,
    StatusNotificacaoEnum statusNotificacaoEnum) {
}
