package com.adso.siatv4.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @UniqueConstraint(columnNames = {"periodo_id", "anio_lectivo_id"})
})
public class PeriodoAnioLectivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;
    
    @ManyToOne
    @JoinColumn(name = "anio_lectivo_id")
    private AnioLectivo anioLectivo;
    
    @Column(nullable = false, unique = true, columnDefinition = "DATE", length = 10)
    private LocalDate fechaInicio;
    @Column(nullable = false, unique = true, columnDefinition = "DATE", length = 10)
    private LocalDate fechaFin;
}
