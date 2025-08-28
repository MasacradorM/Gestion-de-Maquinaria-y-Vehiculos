package sena.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.backend.model.Email;

public interface IEmail extends JpaRepository<Email, Integer> {
    // Métodos personalizados si los necesitas
    boolean existsByEmail(String email);
}
