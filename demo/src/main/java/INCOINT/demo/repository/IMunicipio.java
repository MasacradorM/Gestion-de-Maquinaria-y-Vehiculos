package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Municipio;

public interface IMunicipio extends JpaRepository<Municipio, Integer> {}
