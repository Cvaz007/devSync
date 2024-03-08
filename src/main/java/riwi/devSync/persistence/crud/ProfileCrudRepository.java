package riwi.devSync.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import riwi.devSync.persistence.entity.Profile;

public interface ProfileCrudRepository extends JpaRepository<Profile,Integer> {
}
