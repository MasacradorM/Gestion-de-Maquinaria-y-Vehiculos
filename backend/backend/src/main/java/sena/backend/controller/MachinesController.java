package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.MachinesDTO;
import sena.backend.model.Machines;
import sena.backend.service.MachinesService;

import java.util.List;

@RestController
@RequestMapping("/machines")
@RequiredArgsConstructor
public class MachinesController {

    private final MachinesService service;

    @PostMapping("/register")
    public ResponseEntity<MachinesDTO> registerMachines(@RequestBody MachinesDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Machines>> getAllMachines() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machines> getOneMachines(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Machines>> getMachinesForPlate(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByPlate(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachines(@PathVariable Integer id) {
        service.deleteMachines(id);
        return ResponseEntity.noContent().build();
    }
}
