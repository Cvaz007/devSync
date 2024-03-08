package riwi.devSync.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import riwi.devSync.persistence.crud.PostCrudRepository;
import riwi.devSync.persistence.entity.Post;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final  PostCrudRepository postRepository;
    public List<Post> getAllPots(){
        return postRepository.findAll();
    }

    public Post getPostById(Integer id){
        return postRepository.findById(id).get();
    }

    public void savePost(Post profile){
        postRepository.save(profile);
    }

    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }
}
