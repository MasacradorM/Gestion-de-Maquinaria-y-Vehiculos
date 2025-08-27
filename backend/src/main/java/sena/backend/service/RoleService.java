package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.RoleDTO;
import sena.backend.model.Role;
import sena.backend.repository.IRole;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final IRole repository;

    public List<RoleDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<RoleDTO> findById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    public Role save(RoleDTO dto) {
        Role role = convertToModel(dto);
        return repository.save(role);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<RoleDTO> findByRole(String filter) {
        return repository.findByRoleContainingIgnoreCase(filter)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RoleDTO convertToDTO(Role role) {
        return RoleDTO.builder()
                .role(role.getRole())
                .permissionDescription(role.getPermissionDescription())
                .build();
    }

    private Role convertToModel(RoleDTO dto) {
        return Role.builder()
                .role(dto.getRole())
                .permissionDescription(dto.getPermissionDescription())
                .build();
    }
}

