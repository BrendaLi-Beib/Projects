package org.consultorio_dentalma.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "pagos")
@NoArgsConstructor
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "fecha_pago",  nullable = false)
    private LocalDate fecha = LocalDate.now();

    @Column(nullable = false)
    private BigDecimal cantidad;

    private String descripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tratamiento_id")
    private Tratamiento tratamiento;
}
