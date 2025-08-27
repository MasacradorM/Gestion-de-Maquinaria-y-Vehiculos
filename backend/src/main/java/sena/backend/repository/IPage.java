package sena.backend.repository;

import sena.backend.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPage extends JpaRepository<Page, Integer> {
    List<Page> findByNameContainingIgnoreCase(String filter);
}
