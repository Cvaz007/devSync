package riwi.devSync.domain.repository;

import riwi.devSync.persistence.entity.Post;

import java.util.List;

public interface PostRepository {
     List<Post> getAllPots();
     Post getPostById(Integer id);
     void savePost(Post profile);
     void deletePost(Integer id);
}
