package INCOINT.demo.controller;

import INCOINT.demo.DTO.ActividadDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/actividad")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @PostMapping("/")
    public ResponseEntity<Object> registerActividad(@RequestBody ActividadDTO actividadDTO) {
        responseDTO response = actividadService.save(actividadDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllActividad() {
        var listActividad = actividadService.findAll();
        return new ResponseEntity<>(listActividad, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneActividad(@PathVariable int id) {
        var actividad = actividadService.findById(id);
        if (!actividad.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actividad, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteActividad(@PathVariable int id) {
        responseDTO response = actividadService.deleteActividad(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
