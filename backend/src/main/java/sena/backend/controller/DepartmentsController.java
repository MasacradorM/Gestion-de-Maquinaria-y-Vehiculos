package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.DepartmentsDTO;
import sena.backend.model.Departments;
import sena.backend.service.DepartmentsService;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService service;

    @PostMapping("/register")
    public ResponseEntity<DepartmentsDTO> registerDepartments(@RequestBody DepartmentsDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Departments>> getAllDepartments() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departments> getOneDepartment(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Departments>> getDepartmentsForName(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartments(@PathVariable Integer id) {
        service.deleteDepartments(id);
        return ResponseEntity.noContent().build();
    }
}

