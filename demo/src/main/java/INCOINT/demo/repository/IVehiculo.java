package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Vehiculo;

public interface IVehiculo extends JpaRepository<Vehiculo, Integer> {}
