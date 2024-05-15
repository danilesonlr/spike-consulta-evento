package com.poc.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name = "TB_ANIMAL")
@MappedSuperclass
public abstract class Evento {

    public abstract Long getParentId();

}
