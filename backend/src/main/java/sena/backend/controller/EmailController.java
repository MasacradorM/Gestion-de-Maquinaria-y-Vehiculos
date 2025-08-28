package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.EmailDTO;
import sena.backend.model.Email;
import sena.backend.service.EmailService;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        return ResponseEntity.ok(emailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Integer id) {
        return emailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.save(emailDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Integer id) {
        emailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
