package INCOINT.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import INCOINT.demo.DTO.TipoVehiculoDTO;
import INCOINT.demo.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoVehiculo")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerTipoVehiculo(@RequestBody TipoVehiculoDTO tipoVehiculoDTO) {
        tipoVehiculoService.save(tipoVehiculoDTO);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllTipoVehiculo() {
        var listTipoVehiculo = tipoVehiculoService.findAll();
        return new ResponseEntity<>(listTipoVehiculo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTipoVehiculo(@PathVariable int id) {
        var tipoVehiculo = tipoVehiculoService.findById(id);
        if (!tipoVehiculo.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipoVehiculo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipoVehiculo(@PathVariable int id) {
        var response = tipoVehiculoService.deleteTipoVehiculo(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
