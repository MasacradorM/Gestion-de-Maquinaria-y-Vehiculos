package sena.backend.repository;

import sena.backend.model.Machines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMachines extends JpaRepository<Machines, Integer> {
    List<Machines> findByPlateContainingIgnoreCase(String filter);
}

