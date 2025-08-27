package sena.backend.repository;

import sena.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicle extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByVehicleNameContainingIgnoreCase(String filter);
}
