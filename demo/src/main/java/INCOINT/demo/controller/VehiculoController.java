package INCOINT.demo.controller;

import INCOINT.demo.DTO.VehiculoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        responseDTO response = vehiculoService.save(vehiculoDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllVehiculo() {
        var listVehiculo = vehiculoService.findAll();
        return new ResponseEntity<>(listVehiculo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVehiculo(@PathVariable int id) {
        var vehiculo = vehiculoService.findById(id);
        if (!vehiculo.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vehiculo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVehiculo(@PathVariable int id) {
        responseDTO response = vehiculoService.deleteVehiculo(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
