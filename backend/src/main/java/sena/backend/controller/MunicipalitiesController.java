package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.MunicipalitiesDTO;
import sena.backend.model.Municipalities;
import sena.backend.service.MunicipalitiesService;

import java.util.List;

@RestController
@RequestMapping("/municipalities")
@RequiredArgsConstructor
public class MunicipalitiesController {

    private final MunicipalitiesService service;

    @PostMapping("/register")
    public ResponseEntity<MunicipalitiesDTO> registerMunicipalities(@RequestBody MunicipalitiesDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Municipalities>> getAllMunicipalities() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipalities> getOneMunicipality(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Municipalities>> getMunicipalitiesForName(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMunicipality(@PathVariable Integer id) {
        service.deleteMunicipalities(id);
        return ResponseEntity.noContent().build();
    }
}
