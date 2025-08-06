package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Departamento;

public interface IDepartamento extends JpaRepository<Departamento, Integer> {}
