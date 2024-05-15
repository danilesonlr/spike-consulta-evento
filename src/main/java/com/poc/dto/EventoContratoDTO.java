package com.poc.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoContratoDTO extends EventoDTO {

    private String campoEspecificoContrato;

    private Set<EnvolvidoBasicDTO> envolvidos;
}
