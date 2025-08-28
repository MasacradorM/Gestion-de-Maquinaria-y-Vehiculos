package sena.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.backend.dto.UserLoginDTO;
import sena.backend.model.User;
import sena.backend.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class UserPublicController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody UserLoginDTO loginDTO) {
        Optional<User> user = userService.findByName(loginDTO.getUserName())
                                         .stream()
                                         .filter(u -> u.getPassword().equals(loginDTO.getPassword()))
                                         .findFirst();

        if (user.isPresent()) {
            return ResponseEntity.ok("Login exitoso para " + user.get().getUserName());
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
