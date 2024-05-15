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
//@Domain(value = EventoCertidao.EVENTO_CERTIDAO, masters = Certidao.class)
public class EventoCertidao extends Evento {

    public static final String EVENTO_CERTIDAO = "eventoCertidao";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String name;

    private String caixaAreia;

    @ManyToOne
    @JoinColumn(name = "ID_CERTIDAO")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContextoContrato contextoContrato;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MM_EVENTO_CERTIDAO_ENV",
            joinColumns = @JoinColumn(name = "ID_EVENTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENVOLVIDO"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Usuario> envolvidos;

    @Override
    public Long getParentId() {
        return Optional.ofNullable(this.contextoContrato).map(ContextoContrato::getId).orElse(null);
    }
}
