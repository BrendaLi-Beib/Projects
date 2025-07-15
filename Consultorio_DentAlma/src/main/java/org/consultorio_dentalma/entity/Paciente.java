package org.consultorio_dentalma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nombre;

    @Column(name = "num_tel")
    private String numeroTelefono;

    @OneToMany(mappedBy = "paciente",  fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Cita> citas = new ArrayList<>();

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private HistorialClinico historialClinico;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tratamiento> tratamientos = new ArrayList<>();

}