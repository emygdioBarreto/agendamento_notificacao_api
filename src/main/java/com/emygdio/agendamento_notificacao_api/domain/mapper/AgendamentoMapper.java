package com.emygdio.agendamento_notificacao_api.domain.mapper;

import com.emygdio.agendamento_notificacao_api.domain.Agendamento;
import com.emygdio.agendamento_notificacao_api.domain.dto.AgendamentoDTO;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {

    public AgendamentoDTO toDTO(Agendamento agendamento) {
        if (agendamento == null) {
            return null;
        }
        return new AgendamentoDTO(
                agendamento.getId(),
                agendamento.getEmailDestinatario(),
                agendamento.getTelefoneDestrinario(),
                agendamento.getDataHoraEnvio(),
                agendamento.getDataHoraAgendamento(),
                agendamento.getDataHoraModificacao(),
                agendamento.getMensagem(),
                agendamento.getStatusNotificacao());
    }

    public Agendamento toEntity(AgendamentoDTO agendamentoDTO) {
        if (agendamentoDTO == null) {
            return null;
        }
        Agendamento agendamento = new Agendamento();
        if (agendamentoDTO.id() != null) {
            agendamento.setId(agendamentoDTO.id());
        }
        agendamento.setEmailDestinatario(agendamentoDTO.emailDestinatario());
        agendamento.setTelefoneDestrinario(agendamentoDTO.telefoneDestinatario());
        agendamento.setDataHoraEnvio(agendamentoDTO.dataHoraEnvio());
        agendamento.setDataHoraAgendamento(agendamentoDTO.dataHoraAgendamento());
        agendamento.setDataHoraModificacao(agendamentoDTO.dataHoraModificacao());
        agendamento.setMensagem(agendamentoDTO.mensagem());
        agendamento.setStatusNotificacao(agendamentoDTO.statusNotificacaoEnum());
        return agendamento;
    }
}
