package INCOINT.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import INCOINT.demo.DTO.DepartamentoDTO;
import INCOINT.demo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        departamentoService.save(departamentoDTO);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllDepartamento() {
        var listDepartamento = departamentoService.findAll();
        return new ResponseEntity<>(listDepartamento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDepartamento(@PathVariable int id) {
        var departamento = departamentoService.findById(id);
        if (!departamento.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartamento(@PathVariable int id) {
        var response = departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
