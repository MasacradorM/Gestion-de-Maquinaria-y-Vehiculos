package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.PasswordDTO;
import sena.backend.model.Password;
import sena.backend.service.PasswordService;

import java.util.List;

@RestController
@RequestMapping("/api/passwords")
@RequiredArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @GetMapping
    public ResponseEntity<List<Password>> getAllPasswords() {
        return ResponseEntity.ok(passwordService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Password> getPasswordById(@PathVariable Integer id) {
        return passwordService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Password> createPassword(@RequestBody PasswordDTO passwordDTO) {
        return ResponseEntity.ok(passwordService.save(passwordDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable Integer id) {
        passwordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
