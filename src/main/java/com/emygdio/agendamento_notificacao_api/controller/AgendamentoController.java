package com.emygdio.agendamento_notificacao_api.controller;

import com.emygdio.agendamento_notificacao_api.domain.dto.AgendamentoDTO;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoIn;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoOut;
import com.emygdio.agendamento_notificacao_api.services.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> gravarAgendamento(@RequestBody AgendamentoDTO agendaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(agendaDTO));
    }
}
