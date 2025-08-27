package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.DepartmentsDTO;
import sena.backend.model.Departments;
import sena.backend.repository.IDepartments;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentsService {

    private final IDepartments repository;

    public List<Departments> findAll() {
        return repository.findAll();
    }

    public List<Departments> findByName(String filter) {
        return repository.findByDepartmentsNameContainingIgnoreCase(filter);
    }

    public Optional<Departments> findById(Integer id) {
        return repository.findById(id);
    }

    public DepartmentsDTO save(DepartmentsDTO dto) {
        Departments dept = convertToModel(dto);
        Departments saved = repository.save(dept);
        return convertToDTO(saved);
    }

    public void deleteDepartments(Integer id) {
        repository.deleteById(id);
    }

    // Conversión DTO -> Entidad
    private Departments convertToModel(DepartmentsDTO dto) {
        return Departments.builder()
                .departmentsName(dto.getDepartmentsName())
                .daneCode(dto.getDaneCode())
                .build();
    }

    // Conversión Entidad -> DTO
    private DepartmentsDTO convertToDTO(Departments dept) {
        return DepartmentsDTO.builder()
                .departmentsName(dept.getDepartmentsName())
                .daneCode(dept.getDaneCode())
                .build();
    }
}
