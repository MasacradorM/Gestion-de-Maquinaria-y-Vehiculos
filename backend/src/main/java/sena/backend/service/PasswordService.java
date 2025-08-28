package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.PasswordDTO;
import sena.backend.model.Password;
import sena.backend.repository.IPassword;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordService {

    private final IPassword passwordRepository;

    public List<Password> findAll() {
        return passwordRepository.findAll();
    }

    public Optional<Password> findById(Integer id) {
        return passwordRepository.findById(id);
    }

    public Password save(PasswordDTO dto) {
        Password password = Password.builder()
                .password(dto.getPassword())
                .status(dto.isStatus())
                .build();
        return passwordRepository.save(password);
    }

    public void delete(Integer id) {
        passwordRepository.deleteById(id);
    }
}
