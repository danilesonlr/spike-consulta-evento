package com.poc.resource;

import com.poc.dto.EventoDTO;
import com.poc.repository.EventoContratoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.poc.config.EventoConverter.converterCat;
import static com.poc.config.EventoConverter.converterDog;

@RestController
@RequestMapping("/evento")
@AllArgsConstructor
public class EventoResource {

    private final EventoContratoRepository eventoRepository;

    @GetMapping
    public List<EventoDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(converterCat());
        modelMapper.addConverter(converterDog());

        return eventoRepository.buscaEventos(null).stream().map((element) -> modelMapper.map(element, EventoDTO.class)).toList();
    }

}
