package com.adso.siatv4.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"periodo_nombre", "periodo_codigo", "anio_lectivo_id"})
})
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String periodoNombre;

    @Column(nullable = false, unique = true, length = 1)
    private Integer periodoCodigo;

    @OneToMany(mappedBy = "periodo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<PeriodoAnioLectivo> periodosAniosLectivos;
    
}
