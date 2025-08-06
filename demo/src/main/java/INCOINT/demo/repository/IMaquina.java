package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Maquina;

public interface IMaquina extends JpaRepository<Maquina, Integer> {}
