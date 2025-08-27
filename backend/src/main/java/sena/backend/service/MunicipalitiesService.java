package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.MunicipalitiesDTO;
import sena.backend.model.Departments;
import sena.backend.model.Municipalities;
import sena.backend.repository.IDepartments;
import sena.backend.repository.IMunicipalities;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MunicipalitiesService {

    private final IMunicipalities repository;
    private final IDepartments departmentRepository;

    public List<Municipalities> findAll() {
        return repository.findAll();
    }

    public List<Municipalities> findByName(String filter) {
        return repository.findByMunicipalitiesNameContainingIgnoreCase(filter);
    }

    public Optional<Municipalities> findById(Integer id) {
        return repository.findById(id);
    }

    public MunicipalitiesDTO save(MunicipalitiesDTO dto) {
        Municipalities muni = convertToModel(dto);
        Municipalities saved = repository.save(muni);
        return convertToDTO(saved);
    }

    public void deleteMunicipalities(Integer id) {
        repository.deleteById(id);
    }

    // Conversión DTO -> Entidad
    private Municipalities convertToModel(MunicipalitiesDTO dto) {
        Departments dept = departmentRepository.findById(dto.getDepartmentsId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return Municipalities.builder()
                .municipalitiesName(dto.getMunicipalitiesName())
                .daneCode(dto.getDaneCode())
                .department(dept)
                .build();
    }

    // Conversión Entidad -> DTO
    private MunicipalitiesDTO convertToDTO(Municipalities muni) {
        return MunicipalitiesDTO.builder()
                .municipalitiesName(muni.getMunicipalitiesName())
                .daneCode(muni.getDaneCode())
                .departmentsId(muni.getDepartment().getDepartmentsId())
                .build();
    }
}
