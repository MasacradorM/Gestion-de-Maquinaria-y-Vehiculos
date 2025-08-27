package sena.backend.repository;

import sena.backend.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IWork extends JpaRepository<Work, Integer> {
    List<Work> findByWorkContainingIgnoreCase(String work);
}
