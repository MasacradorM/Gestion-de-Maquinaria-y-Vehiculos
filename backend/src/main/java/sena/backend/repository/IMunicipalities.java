package sena.backend.repository;

import sena.backend.model.Municipalities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMunicipalities extends JpaRepository<Municipalities, Integer> {
    List<Municipalities> findByMunicipalitiesNameContainingIgnoreCase(String filter);
}
