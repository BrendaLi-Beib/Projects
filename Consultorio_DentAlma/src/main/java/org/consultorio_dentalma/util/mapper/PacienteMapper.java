package org.consultorio_dentalma.util.mapper;

import org.consultorio_dentalma.entity.Paciente;
import org.consultorio_dentalma.presentation.dto.PacienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteDTO toDTO(Paciente paciente);
    Paciente toEntity(Paciente paciente);
}
