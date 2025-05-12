package INCOINT.demo.controller;

import INCOINT.demo.DTO.MaquinaDTO;
import INCOINT.demo.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;

    @PostMapping("/")
    public ResponseEntity<Object> registerMaquina(@RequestBody MaquinaDTO maquinaDTO) {
        maquinaService.save(maquinaDTO);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllMaquina() {
        var listMaquina = maquinaService.findAll();
        return new ResponseEntity<>(listMaquina, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMaquina(@PathVariable int id) {
        var maquina = maquinaService.findById(id);
        if (!maquina.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maquina, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMaquina(@PathVariable int id) {
        var response = maquinaService.deleteMaquina(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
