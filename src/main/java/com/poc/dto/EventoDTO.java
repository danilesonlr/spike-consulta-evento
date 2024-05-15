package com.poc.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.poc.domain.EventoCertidao;
import com.poc.domain.EventoContrato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "contexto")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EventoCertidaoDTO.class, name = EventoCertidao.EVENTO_CERTIDAO),
        @JsonSubTypes.Type(value = EventoContratoDTO.class, name = EventoContrato.EVENTO_CONTRATO)
})
@AllArgsConstructor
@NoArgsConstructor
public abstract class EventoDTO {

    private Long id;

    private Long parentId;

}