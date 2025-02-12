package com.emygdio.agendamento_notificacao_api.services;

import com.emygdio.agendamento_notificacao_api.domain.Enum.StatusNotificacaoEnum;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoIn;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoOut;
import com.emygdio.agendamento_notificacao_api.domain.mapper.AgendamentoMapper;
import com.emygdio.agendamento_notificacao_api.exceptions.NotFoundException;
import com.emygdio.agendamento_notificacao_api.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final AgendamentoMapper mapper;

    public AgendamentoService(AgendamentoRepository repository, AgendamentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AgendamentoDtoOut salvar(AgendamentoDtoIn agendaIn) {
        return mapper.toDTO(repository.save(mapper.toEntity(agendaIn)));
    }

    public AgendamentoDtoOut cancelar(@PathVariable Long id) {
        return repository.findById(id)
            .map(agenda -> {
                agenda.setDataHoraModificacao(LocalDateTime.now());
                agenda.setStatusNotificacao(StatusNotificacaoEnum.CANCELADO);
                return mapper.toDTO(repository.save(agenda));
            }).orElseThrow(()-> new NotFoundException("Agendamento não encontrado"));
    }

    public void buscar(Long id) {
        repository.findById(id)
            .map(agenda -> {
                agenda.setDataHoraModificacao(LocalDateTime.now());
                agenda.setStatusNotificacao(StatusNotificacaoEnum.CANCELADO);
                return mapper.toDTO(repository.save(agenda));
            }).orElseThrow(()-> new NotFoundException("Agendamento não encontrado"));
    }
}
