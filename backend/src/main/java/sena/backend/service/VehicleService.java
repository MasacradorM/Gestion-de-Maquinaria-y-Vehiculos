package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.VehicleDTO;
import sena.backend.model.Vehicle;
import sena.backend.repository.IVehicle;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final IVehicle repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public List<Vehicle> findByName(String filter) {
        return repository.findByVehicleNameContainingIgnoreCase(filter);
    }

    public Optional<Vehicle> findById(Integer id) {
        return repository.findById(id);
    }

    public VehicleDTO save(VehicleDTO dto) {
        Vehicle vehicle = convertToModel(dto);
        Vehicle saved = repository.save(vehicle);
        return convertToDTO(saved);
    }

    public void deleteVehicle(Integer id) {
        repository.deleteById(id);
    }

    // Conversión DTO -> Entidad
    private Vehicle convertToModel(VehicleDTO dto) {
        return Vehicle.builder()
                .vehicleName(dto.getVehicleName())
                .vehicleTypeId(dto.getVehicleTypeId())
                .status(true) // por defecto activo
                .build();
    }

    // Conversión Entidad -> DTO
    private VehicleDTO convertToDTO(Vehicle vehicle) {
        return VehicleDTO.builder()
                .vehicleName(vehicle.getVehicleName())
                .vehicleTypeId(vehicle.getVehicleTypeId())
                .build();
    }
}
