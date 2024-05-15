package com.poc.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "TB_CONTEXTO1")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContextoContrato implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @Override
    public boolean isNew() {
        return false;
    }
}
