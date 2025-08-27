package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.PageDTO;
import sena.backend.service.PageService;

import java.util.List;

@RestController
@RequestMapping("/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerPage(@RequestBody PageDTO dto) {
        service.save(dto);
        return ResponseEntity.ok("Page registered successfully");
    }

    @GetMapping
    public ResponseEntity<List<PageDTO>> getAllPages() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnePage(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<PageDTO>> getPagesByName(@RequestParam String filter) {
        return ResponseEntity.ok(service.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePage(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Page deleted successfully");
    }
}
