package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.TypeMachineryDTO;
import sena.backend.model.TypeMachinery;
import sena.backend.service.TypeMachineryService;

import java.util.List;

@RestController
@RequestMapping("/typemachinery")
@RequiredArgsConstructor
public class TypeMachineryController {

    private final TypeMachineryService service;

    @PostMapping("/register")
    public ResponseEntity<TypeMachineryDTO> registerTypeMachinery(@RequestBody TypeMachineryDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeMachinery>> getAllTypeMachinery() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeMachinery> getOneTypeMachinery(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<TypeMachinery>> getTypeMachineryForName(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeMachinery(@PathVariable Integer id) {
        service.deleteTypeMachinery(id);
        return ResponseEntity.noContent().build();
    }
}
