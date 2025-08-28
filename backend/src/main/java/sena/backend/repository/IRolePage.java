package sena.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sena.backend.model.RolePage;

@Repository
public interface IRolePage extends JpaRepository<RolePage, Integer> {
}
