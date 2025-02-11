package com.emygdio.agendamento_notificacao_api.domain;

import com.emygdio.agendamento_notificacao_api.domain.Enum.StatusNotificacaoEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_agendamento_seq")
    @SequenceGenerator(name = "id_agendamento_seq", allocationSize = 1)
    private Long id;

    private String emailDestinatario;
    private String telefoneDestrinario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private String mensagem;
    private StatusNotificacaoEnum statusNotificacao;

    @PrePersist
    private void prePersist() {
        dataHoraAgendamento = LocalDateTime.now();
        statusNotificacao = StatusNotificacaoEnum.AGENDADO;
    }

    public Agendamento(Long id, String emailDestinatario, String telefoneDestrinario, LocalDateTime dataHoraEnvio, LocalDateTime dataHoraAgendamento, LocalDateTime dataHoraModificacao, String mensagem, StatusNotificacaoEnum statusNotificacao) {
        this.id = id;
        this.emailDestinatario = emailDestinatario;
        this.telefoneDestrinario = telefoneDestrinario;
        this.dataHoraEnvio = dataHoraEnvio;
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.dataHoraModificacao = dataHoraModificacao;
        this.mensagem = mensagem;
        this.statusNotificacao = statusNotificacao;
    }

    public Agendamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTelefoneDestrinario() {
        return telefoneDestrinario;
    }

    public void setTelefoneDestrinario(String telefoneDestrinario) {
        this.telefoneDestrinario = telefoneDestrinario;
    }

    public LocalDateTime getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(LocalDateTime dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public LocalDateTime getDataHoraModificacao() {
        return dataHoraModificacao;
    }

    public void setDataHoraModificacao(LocalDateTime dataHoraModificacao) {
        this.dataHoraModificacao = dataHoraModificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public StatusNotificacaoEnum getStatusNotificacao() {
        return statusNotificacao;
    }

    public void setStatusNotificacao(StatusNotificacaoEnum statusNotificacao) {
        this.statusNotificacao = statusNotificacao;
    }
}
