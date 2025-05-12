package INCOINT.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import INCOINT.demo.DTO.TipoDTO;
import INCOINT.demo.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerTipo(@RequestBody TipoDTO tipoDTO) {
        tipoService.save(tipoDTO);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllTipo() {
        var listTipo = tipoService.findAll();
        return new ResponseEntity<>(listTipo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTipo(@PathVariable int id) {
        var tipo = tipoService.findById(id);
        if (!tipo.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipo(@PathVariable int id) {
        var response = tipoService.deleteTipo(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
