package INCOINT.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import INCOINT.demo.DTO.TipoMaquinariaDTO;
import INCOINT.demo.service.TipoMaquinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoMaquinaria")
public class TipoMaquinariaController {

    @Autowired
    private TipoMaquinariaService tipoMaquinariaService;

    @PostMapping("/")
    public ResponseEntity<Object> registerTipoMaquinaria(@RequestBody TipoMaquinariaDTO tipoMaquinariaDTO) {
        tipoMaquinariaService.save(tipoMaquinariaDTO);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllTipoMaquinaria() {
        var listTipoMaquinaria = tipoMaquinariaService.findAll();
        return new ResponseEntity<>(listTipoMaquinaria, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTipoMaquinaria(@PathVariable int id) {
        var tipoMaquinaria = tipoMaquinariaService.findById(id);
        if (!tipoMaquinaria.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipoMaquinaria, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipoMaquinaria(@PathVariable int id) {
        var response = tipoMaquinariaService.deleteTipoMaquinaria(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
