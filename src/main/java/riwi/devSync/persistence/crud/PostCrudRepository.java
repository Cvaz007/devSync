package riwi.devSync.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import riwi.devSync.persistence.entity.Post;

public interface PostCrudRepository extends JpaRepository<Post,Integer> {
}
