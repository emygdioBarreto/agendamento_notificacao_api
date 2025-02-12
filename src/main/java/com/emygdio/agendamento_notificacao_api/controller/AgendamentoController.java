package com.emygdio.agendamento_notificacao_api.controller;

import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoIn;
import com.emygdio.agendamento_notificacao_api.domain.dto.in.AgendamentoDtoOut;
import com.emygdio.agendamento_notificacao_api.services.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AgendamentoDtoOut> gravarAgendamento(@RequestBody AgendamentoDtoIn agendaIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(agendaIn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDtoOut> cancelarAgendamento(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.cancelar(id));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void buscarAgendamentoPorId(@PathVariable("id") Long id) {
        service.buscar(id);
    }
}
