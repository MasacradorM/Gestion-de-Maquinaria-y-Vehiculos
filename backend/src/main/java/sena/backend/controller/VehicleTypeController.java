package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.VehicleTypeDTO;
import sena.backend.model.VehicleType;
import sena.backend.service.VehicleTypeService;

import java.util.List;

@RestController
@RequestMapping("/vehicle-type")
@RequiredArgsConstructor
public class VehicleTypeController {

    private final VehicleTypeService service;

    @PostMapping("/register")
    public ResponseEntity<VehicleTypeDTO> registerVehicleType(@RequestBody VehicleTypeDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleType> getOneVehicleType(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<VehicleType>> getVehicleTypeForName(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleType(@PathVariable Integer id) {
        service.deleteVehicleType(id);
        return ResponseEntity.noContent().build();
    }
}
