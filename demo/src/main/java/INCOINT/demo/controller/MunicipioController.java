package INCOINT.demo.controller;

import INCOINT.demo.DTO.MunicipioDTO;
import INCOINT.demo.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @PostMapping("/")
    public ResponseEntity<Object> registerMunicipio(@RequestBody MunicipioDTO municipioDTO) {
        municipioService.save(municipioDTO);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllMunicipio() {
        var listMunicipio = municipioService.findAll();
        return new ResponseEntity<>(listMunicipio, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMunicipio(@PathVariable int id) {
        var municipio = municipioService.findById(id);
        if (!municipio.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMunicipio(@PathVariable int id) {
        var response = municipioService.deleteMunicipio(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
