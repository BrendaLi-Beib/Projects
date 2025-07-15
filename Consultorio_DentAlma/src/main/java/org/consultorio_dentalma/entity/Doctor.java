package org.consultorio_dentalma.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="doctores")
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nombre;
    @Column(name = "num_tel")
    private String numeroTelefono;

    private String especialidad;

    @OneToMany(mappedBy = "doctor")
    private List<Cita> citas;
}
