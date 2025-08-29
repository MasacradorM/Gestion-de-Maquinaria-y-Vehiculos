package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.ReportVehicleDTO;
import sena.backend.service.ReportVehicleService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/report-vehicles")
@RequiredArgsConstructor
public class ReportVehicleController {

    private final ReportVehicleService service;

    // Registrar nuevo reporte
    @PostMapping
    public ResponseEntity<ReportVehicleDTO> registerVehicleReport(@RequestBody ReportVehicleDTO vehicleReport) {
        return ResponseEntity.ok(service.save(vehicleReport));
    }

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<ReportVehicleDTO>> getAllVehicleReport() {
        return ResponseEntity.ok(service.findAll());
    }

    // Obtener por ID
    @GetMapping("/{vehicleReportId}")
    public ResponseEntity<ReportVehicleDTO> getOneVehicleReport(@PathVariable Integer vehicleReportId) {
        return service.findById(vehicleReportId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Filtrar por fecha
    @GetMapping("/filter")
    public ResponseEntity<List<ReportVehicleDTO>> getFilteredList(@RequestParam("date") Date filterDate) {
        return ResponseEntity.ok(service.filterForDate(filterDate));
    }

    // Eliminar por ID
    @DeleteMapping("/{vehicleReportId}")
    public ResponseEntity<Void> deleteVehicleReport(@PathVariable Integer vehicleReportId) {
        service.deleteVehicleReport(vehicleReportId);
        return ResponseEntity.noContent().build();
    }
}

