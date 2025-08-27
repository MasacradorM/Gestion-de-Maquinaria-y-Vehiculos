package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.VehicleTypeDTO;
import sena.backend.model.VehicleType;
import sena.backend.repository.IVehicleType;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {

    private final IVehicleType repository;

    public List<VehicleType> findAll() {
        return repository.findAll();
    }

    public List<VehicleType> findByName(String filter) {
        return repository.findByVehicleTypeNameContainingIgnoreCase(filter);
    }

    public Optional<VehicleType> findById(Integer id) {
        return repository.findById(id);
    }

    public VehicleTypeDTO save(VehicleTypeDTO dto) {
        VehicleType vehicleType = convertToModel(dto);
        VehicleType saved = repository.save(vehicleType);
        return convertToDTO(saved);
    }

    public void deleteVehicleType(Integer id) {
        repository.deleteById(id);
    }

    // Conversión DTO -> Entidad
    private VehicleType convertToModel(VehicleTypeDTO dto) {
        return VehicleType.builder()
                .vehicleTypeName(dto.getVehicleTypeName())
                .build();
    }

    // Conversión Entidad -> DTO
    private VehicleTypeDTO convertToDTO(VehicleType vehicleType) {
        return VehicleTypeDTO.builder()
                .vehicleTypeName(vehicleType.getVehicleTypeName())
                .build();
    }
}
