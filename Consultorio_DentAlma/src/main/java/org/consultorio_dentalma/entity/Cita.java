package org.consultorio_dentalma.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Entity
@Table(name = "citas")
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private LocalTime hora;

    @Enumerated(EnumType.ORDINAL)
    private EstadoCita estado = EstadoCita.AGENDADA;

    private String motivo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
