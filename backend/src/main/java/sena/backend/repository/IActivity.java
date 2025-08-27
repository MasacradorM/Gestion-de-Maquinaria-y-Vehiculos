package sena.backend.repository;

import sena.backend.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IActivity extends JpaRepository<Activity, Integer> {
    List<Activity> findByActivityNameContainingIgnoreCase(String activityName);
}
