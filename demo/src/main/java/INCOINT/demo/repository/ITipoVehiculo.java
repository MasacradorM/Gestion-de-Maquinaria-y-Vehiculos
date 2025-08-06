package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.TipoVehiculo;

public interface ITipoVehiculo extends JpaRepository<TipoVehiculo, Integer> {}
