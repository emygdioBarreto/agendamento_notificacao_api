package com.emygdio.agendamento_notificacao_api.repositories;

import com.emygdio.agendamento_notificacao_api.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
