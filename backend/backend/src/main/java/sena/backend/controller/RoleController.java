package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.RoleDTO;
import sena.backend.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerRole(@RequestBody RoleDTO dto) {
        service.save(dto);
        return ResponseEntity.ok("Role registered successfully");
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneRole(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<RoleDTO>> getRolesByName(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByRole(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Role deleted successfully");
    }
}
