package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.ReportMachineryDTO;
import sena.backend.service.ReportMachineryService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/report-machinery")
@RequiredArgsConstructor
public class ReportMachineryController {

    private final ReportMachineryService service;

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<ReportMachineryDTO>> getAllReports() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReportMachineryDTO> getReportById(@PathVariable Integer id) {
        Optional<ReportMachineryDTO> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Filtrar por fecha
    @GetMapping("/filter")
    public ResponseEntity<List<ReportMachineryDTO>> getReportsByDate(@RequestParam("date") Date date) {
        return ResponseEntity.ok(service.filterForDate(date));
    }

    // Crear nuevo reporte
    @PostMapping
    public ResponseEntity<ReportMachineryDTO> createReport(@RequestBody ReportMachineryDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    // Actualizar reporte
    @PutMapping("/{id}")
    public ResponseEntity<ReportMachineryDTO> updateReport(@PathVariable Integer id, @RequestBody ReportMachineryDTO dto) {
        dto.setReportMachineryId(id);
        return ResponseEntity.ok(service.save(dto));
    }

    // Eliminar reporte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Integer id) {
        service.deleteReportMachinery(id);
        return ResponseEntity.noContent().build();
    }
}

