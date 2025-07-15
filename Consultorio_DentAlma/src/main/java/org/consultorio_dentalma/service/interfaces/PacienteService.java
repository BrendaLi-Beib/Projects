package org.consultorio_dentalma.service.interfaces;

import org.consultorio_dentalma.entity.Paciente;
import org.consultorio_dentalma.presentation.dto.PacienteDTO;
import org.consultorio_dentalma.repository.PacienteRepository;
import org.consultorio_dentalma.util.mapper.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper  pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public Optional<Paciente> findPacienteByNumeroTelefono(String numeroTelefono) {
        return pacienteRepository.findPacienteByNumeroTelefono(numeroTelefono);
    }
    public List<PacienteDTO> getAllPacientes(){
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<Paciente> getPacienteById(Long id){
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> getPacienteByName(String nombre){
        return pacienteRepository.findPacienteByNombre(nombre);
    }

    public Paciente savePaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> updatePaciente(Long id, Paciente paciente){
        return pacienteRepository.findById(id)
                .map(p ->{
                    p.setNombre(paciente.getNombre());
                    p.setNumeroTelefono(paciente.getNumeroTelefono());
                    return pacienteRepository.save(p);
                });
    }

   public void deletePaciente(Long id){
       pacienteRepository.deleteById(id);
    }

}
