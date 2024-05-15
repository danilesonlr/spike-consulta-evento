package com.poc.config;

import com.poc.domain.EventoCertidao;
import com.poc.domain.EventoContrato;
import com.poc.dto.EventoCertidaoDTO;
import com.poc.dto.EventoContratoDTO;
import com.poc.dto.EventoDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

public class EventoConverter {

    private EventoConverter() {

    }

    public static Converter<EventoCertidao, EventoDTO> converterCat() {
        return new GenericConverter<>() {
            @Override
            public EventoDTO convert(MappingContext<EventoCertidao, EventoDTO> mappingContext) {
                return new ModelMapper().map(mappingContext.getSource(), EventoCertidaoDTO.class);
            }
        };
    }

    public static Converter<EventoContrato, EventoDTO> converterDog() {
        return new GenericConverter<>() {
            @Override
            public EventoDTO convert(MappingContext<EventoContrato, EventoDTO> mappingContext) {
                return new ModelMapper().map(mappingContext.getSource(), EventoContratoDTO.class);
            }
        };
    }

}
