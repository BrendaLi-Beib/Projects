package org.consultorio_dentalma.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tratamientos")
@NoArgsConstructor
@Getter
@Setter
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_tratamiento")
    private TipoTratamiento tipoTratamiento;

    @NotNull
    private BigDecimal costo;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado_tratamiento")
    private EstadoTratamiento estado;

    private String observaciones;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToMany(mappedBy = "tratamiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Pago> pagos = new ArrayList<>();

}
