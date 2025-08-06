package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Obra;

public interface IObra extends JpaRepository<Obra, Integer> {}
