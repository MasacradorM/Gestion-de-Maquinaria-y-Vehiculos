package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Tipo;

public interface ITipo extends JpaRepository<Tipo, Integer> {}
