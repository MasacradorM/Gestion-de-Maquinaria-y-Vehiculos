package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.TypeMachineryDTO;
import sena.backend.model.TypeMachinery;
import sena.backend.repository.ITypeMachinery;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeMachineryService {

    private final ITypeMachinery repository;

    public List<TypeMachinery> findAll() {
        return repository.findAll();
    }

    public List<TypeMachinery> findByName(String filter) {
        return repository.findByTypeMachineryNameContainingIgnoreCase(filter);
    }

    public Optional<TypeMachinery> findById(Integer id) {
        return repository.findById(id);
    }

    public TypeMachineryDTO save(TypeMachineryDTO dto) {
        TypeMachinery typeMachinery = convertToModel(dto);
        TypeMachinery saved = repository.save(typeMachinery);
        return convertToDTO(saved);
    }

    public void deleteTypeMachinery(Integer id) {
        repository.deleteById(id);
    }

    // Conversión DTO -> Entidad
    private TypeMachinery convertToModel(TypeMachineryDTO dto) {
        return TypeMachinery.builder()
                .typeMachineryName(dto.getTypeMachineryName())
                .build();
    }

    // Conversión Entidad -> DTO
    private TypeMachineryDTO convertToDTO(TypeMachinery typeMachinery) {
        return TypeMachineryDTO.builder()
                .typeMachineryName(typeMachinery.getTypeMachineryName())
                .build();
    }
}

