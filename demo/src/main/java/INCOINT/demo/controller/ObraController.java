package INCOINT.demo.controller;

import INCOINT.demo.DTO.ObraDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/obra")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @PostMapping("/")
    public ResponseEntity<Object> registerObra(@RequestBody ObraDTO obraDTO) {
        responseDTO response = obraService.save(obraDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllObra() {
        var listObra = obraService.findAll();
        return new ResponseEntity<>(listObra, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneObra(@PathVariable int id) {
        var obra = obraService.findById(id);
        if (!obra.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obra, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteObra(@PathVariable int id) {
        responseDTO response = obraService.deleteObra(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
