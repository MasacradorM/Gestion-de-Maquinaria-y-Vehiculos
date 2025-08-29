package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.UserRegisterDTO;
import sena.backend.model.User;
import sena.backend.repository.IUser;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUser userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String filter) {
        return userRepository.findByUserNameContainingIgnoreCase(filter);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public void save(UserRegisterDTO dto) {
        User user = convertToModel(dto);
        userRepository.save(user);
    }

    public UserRegisterDTO convertToDTO(User user) {
        return UserRegisterDTO.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .emailId(user.getEmailId())
                .phone(user.getPhone())
                .identification(user.getIdentification())
                .modificationTime(user.getModificationTime())
                .build();
    }

    public User convertToModel(UserRegisterDTO dto) {
        return User.builder()
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .emailId(dto.getEmailId())
                .phone(dto.getPhone())
                .identification(dto.getIdentification())
                .modificationTime(dto.getModificationTime())
                .status(true)
                .build();
    }
}
