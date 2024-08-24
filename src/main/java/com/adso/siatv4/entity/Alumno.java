package com.adso.siatv4.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Alumno extends Persona{

    @OneToMany(mappedBy ="alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

}
