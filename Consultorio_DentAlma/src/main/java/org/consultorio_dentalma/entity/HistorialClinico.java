package org.consultorio_dentalma.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "historial_clinico")
public class HistorialClinico {
    @Id
    @GeneratedValue
    private Long id;

    private String descripcion;

    @Column(name="fecha_registro")
    private LocalDate fecha;

    @Column(name ="documentos")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "historial_documentos", joinColumns = @JoinColumn(name = "historial_id"))
    private List<String> imagenes;

    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    @PrePersist
    public void fechaRegistro() {
        if (fecha == null) {
            fecha = LocalDate.now();
        }
    }

}
