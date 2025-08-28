package sena.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sena.backend.model.User;

import java.util.List;

@Repository
public interface IUser extends JpaRepository<User, Integer> {
    List<User> findByUserNameContainingIgnoreCase(String filter);
}
