package INCOINT.demo.controller;

import INCOINT.demo.DTO.ReporteVehiculoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.service.ReporteVehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reporteVehiculos")
public class ReporteVehiculosController {

    @Autowired
    private ReporteVehiculosService servicio;

    @PostMapping("/")
    public ResponseEntity<Object> registerReporte(@RequestBody ReporteVehiculoDTO reporteVehiculoDTO) {
        responseDTO response = servicio.save(reporteVehiculoDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllReporte() {
        var lista = servicio.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneReporte(@PathVariable int id) {
        var reporte = servicio.findById(id);
        if (!reporte.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReporte(@PathVariable int id) {
        responseDTO response = servicio.deleteReporteVehiculos(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
