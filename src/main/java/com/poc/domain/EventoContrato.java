package com.poc.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
//@Domain(value = EventoCertidao.EVENTO_CONTRATO, masters = Contrato.class)
public class EventoContrato extends Evento {

    public static final String EVENTO_CONTRATO = "eventoContrato";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContextoCertidao contextoCertidao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MM_EVENTO_CONTRATO_ENV",
            joinColumns = @JoinColumn(name = "ID_EVENTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENVOLVIDO"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Usuario> envolvidos;

    @Override
    public Long getParentId() {
        return Optional.ofNullable(this.contextoCertidao).map(ContextoCertidao::getId).orElse(null);
    }
}
