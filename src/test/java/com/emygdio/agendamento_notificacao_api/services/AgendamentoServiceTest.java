package com.emygdio.agendamento_notificacao_api.services;

import com.emygdio.agendamento_notificacao_api.domain.Agendamento;
import com.emygdio.agendamento_notificacao_api.domain.Enum.StatusNotificacaoEnum;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoIn;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoOut;
import com.emygdio.agendamento_notificacao_api.domain.mapper.AgendamentoMapper;
import com.emygdio.agendamento_notificacao_api.repositories.AgendamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

    @InjectMocks
    private AgendamentoService service;

    @Mock
    private AgendamentoRepository repository;

    @Mock
    private AgendamentoMapper mapper;

    private AgendamentoDtoIn agendamentoDtoIn;
    private AgendamentoDtoOut agendamentoDtoOut;
    private Agendamento agendamento;

    @BeforeEach
    void setUp() throws ParseException {
        agendamento = new Agendamento(
                1L,
                "emygdio.barreto@gmail.com",
                "(81) 991725082",
                "Teste de envio de mensagem de agendamento",
                LocalDateTime.of(2025,2,11,8,7,41),
                LocalDateTime.now(),
                null,
                StatusNotificacaoEnum.CANCELADO
        );

        agendamentoDtoIn = new AgendamentoDtoIn(
                "emygdio.barreto@gmail.com",
                "(81) 991725082",
                "Teste de envio de mensagem de agendamento",
                LocalDateTime.of(2025,2,11,8,7,41)
        );

        agendamentoDtoOut = new AgendamentoDtoOut(
                1L,
                "emygdio.barreto@gmail.com",
                "(81) 991725082",
                "Teste de envio de mensagem de agendamento",
                LocalDateTime.of(2025,2,11,8,7,41),
                StatusNotificacaoEnum.CANCELADO
        );
    }

    @Test
    void deveGravarAgendamentoComSucesso() {
        when(mapper.toEntity(agendamentoDtoIn)).thenReturn(agendamento);
        when(repository.save(agendamento)).thenReturn(agendamento);
        when(mapper.toDTO(agendamento)).thenReturn(agendamentoDtoOut);

        AgendamentoDtoOut out = service.salvar(agendamentoDtoIn);

        verify(mapper, times(1)).toEntity(agendamentoDtoIn);
        verify(repository, times(1)).save(agendamento);
        verify(mapper, times(1)).toDTO(agendamento);

        assertThat(out).usingRecursiveComparison().isEqualTo(agendamentoDtoOut);
    }
}
