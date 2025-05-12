package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Actividad;

public interface IActividad extends JpaRepository<Actividad, Integer> {}
