package sena.backend.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import sena.backend.dto.EmailDTO;
import sena.backend.model.Email;
import sena.backend.repository.IEmail;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final IEmail IEmail;

    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    public Optional<Email> findById(Integer id) {
        return emailRepository.findById(id);
    }

    public Email save(EmailDTO dto) {
        Email email = Email.builder()
                .email(dto.getEmail())
                .status(dto.isStatus())
                .build();
        return emailRepository.save(email);
    }

    public void delete(Integer id) {
        emailRepository.deleteById(id);
    }
}
