package sena.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.backend.model.Password;

public interface IPassword extends JpaRepository<Password, Integer> {
    boolean existsByPassword(String password);
}
