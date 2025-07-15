package org.consultorio_dentalma.presentation.controller;

import org.consultorio_dentalma.entity.Paciente;
import org.consultorio_dentalma.presentation.dto.PacienteDTO;
import org.consultorio_dentalma.service.interfaces.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    public List<PacienteDTO> obtenerTodos() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Paciente> getPacienteByName(@PathVariable String name) {
       return pacienteService.getPacienteByName(name)
               .map(pac -> ResponseEntity.ok(pac))
               .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{num}")
    public ResponseEntity<Paciente> getPacienteByPhone(@PathVariable String num) {
        return pacienteService.findPacienteByNumeroTelefono(num)
                .map(pac -> ResponseEntity.ok(pac))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{paciente}")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) {
        Paciente nuevo = pacienteService.savePaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.updatePaciente(id, paciente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}