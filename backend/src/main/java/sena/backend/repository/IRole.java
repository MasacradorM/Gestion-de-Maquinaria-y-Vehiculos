package sena.backend.repository;

import sena.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRole extends JpaRepository<Role, Integer> {
    List<Role> findByRoleContainingIgnoreCase(String filter);
}
