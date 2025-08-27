package sena.backend.repository;

import sena.backend.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartments extends JpaRepository<Departments, Integer> {
    List<Departments> findByDepartmentsNameContainingIgnoreCase(String filter);
}