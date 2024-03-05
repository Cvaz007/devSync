package riwi.devSync.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import riwi.devSync.persistence.entity.User;

import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
