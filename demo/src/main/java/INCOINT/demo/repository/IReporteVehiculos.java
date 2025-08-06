package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.ReporteVehiculos;

public interface IReporteVehiculos extends JpaRepository<ReporteVehiculos, Integer> {}
