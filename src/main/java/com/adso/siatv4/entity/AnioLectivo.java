package com.adso.siatv4.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnioLectivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 4)
    private Integer anioNumero;

    @OneToMany(mappedBy ="anioLectivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    @OneToMany(mappedBy ="anioLectivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<PeriodoAnioLectivo> periodosAniosLectivos;
}
