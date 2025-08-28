package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.UserRegisterDTO;
import sena.backend.model.User;
import sena.backend.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUsuario(@RequestBody UserRegisterDTO usuario) {
        userService.save(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOneUsuario(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> getUsuariosForName(@RequestParam String filter) {
        return ResponseEntity.ok(userService.findByName(filter));
    }
}
