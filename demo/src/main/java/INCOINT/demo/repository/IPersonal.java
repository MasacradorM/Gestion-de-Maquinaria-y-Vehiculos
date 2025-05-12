package INCOINT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import INCOINT.demo.model.Personal;

public interface IPersonal extends JpaRepository<Personal, Integer> {}