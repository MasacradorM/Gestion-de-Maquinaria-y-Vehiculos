package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.TipoMaquinaria;

public interface ITipoMaquinaria extends JpaRepository<TipoMaquinaria, Integer> {}
