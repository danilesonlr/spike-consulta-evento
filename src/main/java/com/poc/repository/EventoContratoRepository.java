package com.poc.repository;


import com.poc.domain.Evento;
import com.poc.domain.EventoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventoContratoRepository extends JpaRepository<EventoContrato, Long> {



    @Query(value = "select e from com.poc.domain.Evento e join e.envolvidos env where (:envolvidos is null or env.id in (:envolvidos))")
    List<Evento> buscaEventos(List<Long> envolvidos);

}
