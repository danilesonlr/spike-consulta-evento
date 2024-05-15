package com.poc.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoCertidaoDTO extends EventoDTO {

    private String campoEspecificoCertidao;

    private Set<EnvolvidoBasicDTO> envolvidos;
}
