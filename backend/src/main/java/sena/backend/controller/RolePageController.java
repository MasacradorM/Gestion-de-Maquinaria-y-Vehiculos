package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.RolePageDTO;
import sena.backend.model.RolePage;
import sena.backend.service.RolePageService;

import java.util.List;

@RestController
@RequestMapping("/api/role-page")
@RequiredArgsConstructor
public class RolePageController {

    private final RolePageService rolePageService;

    @GetMapping
    public ResponseEntity<List<RolePage>> getAll() {
        return ResponseEntity.ok(rolePageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolePage> getById(@PathVariable Integer id) {
        return rolePageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RolePage> create(@RequestBody RolePageDTO dto) {
        return ResponseEntity.ok(rolePageService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rolePageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
