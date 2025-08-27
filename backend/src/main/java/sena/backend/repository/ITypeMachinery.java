package sena.backend.repository;

import sena.backend.model.TypeMachinery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeMachinery extends JpaRepository<TypeMachinery, Integer> {
    List<TypeMachinery> findByTypeMachineryNameContainingIgnoreCase(String filter);
}
