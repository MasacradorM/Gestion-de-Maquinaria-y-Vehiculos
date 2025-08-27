package sena.backend.controller;

import sena.backend.dto.WorkDTO;
import sena.backend.service.WorkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @PostMapping("/register")
    public ResponseEntity<?> registerWork(@RequestBody WorkDTO work) {
        workService.save(work);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkDTO>> getAllWork() {
        return ResponseEntity.ok(workService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneObra(@PathVariable Integer id) {
        Optional<WorkDTO> work = workService.findById(id);
        if (!work.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(work, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<WorkDTO>> getObraForName(@RequestParam String filter) {
        return ResponseEntity.ok(workService.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWork(@PathVariable Integer id) {
        return ResponseEntity.ok(workService.deleteWork(id));
    }
}

