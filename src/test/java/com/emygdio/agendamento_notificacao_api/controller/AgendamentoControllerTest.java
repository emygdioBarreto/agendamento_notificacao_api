package com.emygdio.agendamento_notificacao_api.controller;

import com.emygdio.agendamento_notificacao_api.domain.Enum.StatusNotificacaoEnum;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoIn;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoOut;
import com.emygdio.agendamento_notificacao_api.services.AgendamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AgendamentoControllerTest {

    @InjectMocks
    AgendamentoController agendamentoController;

    @Mock
    AgendamentoService service;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private AgendamentoDtoIn agendamentoDtoIn;
    private AgendamentoDtoOut agendamentoDtoOut;

    @BeforeEach
    void setUp() throws ParseException {
        mockMvc = MockMvcBuilders.standaloneSetup(agendamentoController).build();

        objectMapper.registerModule(new JavaTimeModule());

        agendamentoDtoIn = new AgendamentoDtoIn(
                "emygdio.barreto@gmail.com",
                "(81) 991725082",
                "Teste de envio de mensagem de agendamento",
                LocalDateTime.of(2025,2,11,8,7,41));

        agendamentoDtoOut = new AgendamentoDtoOut(
                1l,
                "emygdio.barreto@gmail.com",
                "(81) 991725082",
                "Teste de envio de mensagem de agendamento",
                LocalDateTime.of(2025,2,11,8,7,41),
                StatusNotificacaoEnum.CANCELADO);
    }

    @Test
    void deveCriarAgendamentoComSucesso() throws Exception {
        when(service.salvar(agendamentoDtoIn)).thenReturn(agendamentoDtoOut);

        mockMvc.perform(post("/agendamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(agendamentoDtoIn)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.emailDestinatario").value(agendamentoDtoIn.emailDestinatario()))
                .andExpect(jsonPath("$.telefoneDestinatario").value(agendamentoDtoIn.telefoneDestinatario()))
                .andExpect(jsonPath("$.mensagem").value(agendamentoDtoIn.mensagem()))
                .andExpect(jsonPath("$.dataHoraEnvio").value("11.02.2025 08:07:41"));

        verify(service, times(1)).salvar(agendamentoDtoIn);
    }
}
