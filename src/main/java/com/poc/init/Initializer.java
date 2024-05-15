package com.poc.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.domain.*;
import com.poc.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Initializer implements CommandLineRunner {

    private final ApplicationContext beanContext;
    private final EventoContratoRepository eventoContratoRepository;
    private final EventoCertidaoRepository eventoCertidaoRepository;
    private final ContextoContratoRepository contextoContratoRepository;
    private final ContextoCertidaoRepository contextoCertidaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;


    @Override
    public void run(String... args) throws Exception {

        ContextoContrato contextoContrato = ContextoContrato.builder().nome("contrato").build();
        contextoContratoRepository.save(contextoContrato);

        ContextoCertidao contextoCertidao = ContextoCertidao.builder().nome("certidao").build();
        contextoCertidaoRepository.save(contextoCertidao);

        Usuario usuario = Usuario.builder().nome("meu_nome").build();
        usuarioRepository.save(usuario);
        List<Usuario> envolvidos = List.of(usuario);

        EventoCertidao eventoCertidao = EventoCertidao.builder().name("Evento Certidao").contextoContrato(contextoContrato).envolvidos(envolvidos).build();
        eventoCertidaoRepository.save(eventoCertidao);

        EventoContrato eventoContrato = EventoContrato.builder().name("Evento Contrato").contextoCertidao(contextoCertidao).envolvidos(envolvidos).build();
        eventoContratoRepository.save(eventoContrato);


        eventoContratoRepository.buscaEventos(List.of(1L));
    }


}
