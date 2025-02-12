package com.emygdio.agendamento_notificacao_api.domain.mapper;

import com.emygdio.agendamento_notificacao_api.domain.Agendamento;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoIn;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoOut;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {

    public AgendamentoDtoOut toDTO(Agendamento agenda) {
        if (agenda == null) {
            return null;
        }
        return new AgendamentoDtoOut (
                agenda.getId(),
                agenda.getEmailDestinatario(),
                agenda.getTelefoneDestrinario(),
                agenda.getMensagem(),
                agenda.getDataHoraEnvio(),
                agenda.getStatusNotificacao()
        );
    }

    public Agendamento toEntity(AgendamentoDtoIn inn) {
        if (inn == null) {
            return null;
        }
        Agendamento agendamento = new Agendamento();
        agendamento.setId(null);
        agendamento.setEmailDestinatario(inn.emailDestinatario());
        agendamento.setTelefoneDestrinario(inn.telefoneDestinatario());
        agendamento.setMensagem(inn.mensagem());
        agendamento.setDataHoraEnvio(inn.dataHoraEnvio());
        return agendamento;
    }

    public Agendamento toEntity(AgendamentoDtoOut out) {
        if (out == null) {
            return null;
        }
        Agendamento agendamento = new Agendamento();
        if (out.id() != null) {
            agendamento.setId(out.id());
        }
        agendamento.setEmailDestinatario(out.emailDestinatario());
        agendamento.setTelefoneDestrinario(out.telefoneDestinatario());
        agendamento.setMensagem(out.mensagem());
        agendamento.setDataHoraEnvio(out.dataHoraEnvio());
        agendamento.setStatusNotificacao(out.statusNotificacaoEnum());
        return agendamento;
    }
}
