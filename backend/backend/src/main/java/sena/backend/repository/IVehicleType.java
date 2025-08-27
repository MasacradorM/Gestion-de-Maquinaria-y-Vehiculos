package sena.backend.repository;

import sena.backend.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleType extends JpaRepository<VehicleType, Integer> {
    List<VehicleType> findByVehicleTypeNameContainingIgnoreCase(String filter);
}
