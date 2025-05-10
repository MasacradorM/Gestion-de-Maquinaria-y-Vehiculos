package INCOINT.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import INCOINT.demo.DTO.TrayectoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.service.TrayectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trayecto")
public class TrayectoController {

    @Autowired
    private TrayectoService trayectoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerTrayecto(@RequestBody TrayectoDTO trayectoDTO) {
        responseDTO response = trayectoService.save(trayectoDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllTrayecto() {
        var listTrayecto = trayectoService.findAll();
        return new ResponseEntity<>(listTrayecto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTrayecto(@PathVariable int id) {
        var trayecto = trayectoService.findById(id);
        if (!trayecto.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trayecto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTrayecto(@PathVariable int id) {
        var response = trayectoService.deleteTrayecto(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
