package sena.backend.controller;

import sena.backend.dto.ActivityDTO;
import sena.backend.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/register")
    public ResponseEntity<?> registerActivity(@RequestBody ActivityDTO activity) {
        activityService.save(activity);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivity() {
        return ResponseEntity.ok(activityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneActivity(@PathVariable Integer id) {
        Optional<ActivityDTO> activity = activityService.findById(id);
        if (!activity.isPresent()) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ActivityDTO>> getActivityForName(@RequestParam String filter) {
        return ResponseEntity.ok(activityService.findByName(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer id) {
        return ResponseEntity.ok(activityService.deleteActivity(id));
    }
}

