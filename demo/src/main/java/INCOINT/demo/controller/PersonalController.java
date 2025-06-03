package INCOINT.demo.controller;

import INCOINT.demo.DTO.PersonalDTO;
import INCOINT.demo.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerPersonal(@RequestBody PersonalDTO personalDTO) {
        personalService.save(personalDTO);
        return new ResponseEntity<>("Registro OK", HttpStatus.OK);
    }
@GetMapping("/ping")
public ResponseEntity<Object> ping() {
    return new ResponseEntity<>("Servicio activo", HttpStatus.OK);
}


    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePersonal(@PathVariable int id) {
        var personal = personalService.findById(id);
        if (!personal.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonal(@PathVariable int id) {
        var response = personalService.deletePersonal(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
