package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Trayecto;

public interface ITrayecto extends JpaRepository<Trayecto, Integer> {}
