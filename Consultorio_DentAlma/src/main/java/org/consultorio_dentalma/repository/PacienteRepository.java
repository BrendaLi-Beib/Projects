package org.consultorio_dentalma.repository;


import org.consultorio_dentalma.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findPacienteByNumeroTelefono(String numeroTelefono);
    Optional<Paciente> findPacienteByNombre(String nombre);

}