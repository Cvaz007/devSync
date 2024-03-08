package riwi.devSync.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riwi.devSync.domain.service.PostService;
import riwi.devSync.persistence.entity.Post;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPots();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        try {
            Post post = postService.getPostById(id);
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public void savePost(@RequestBody Post post) {
        postService.savePost(post);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        try {
            Post currentPost = postService.getPostById(id);
            currentPost.setTitle(post.getTitle());
            currentPost.setDescription(post.getDescription());
            currentPost.setImage(post.getImage());
            currentPost.setDatePublished(post.getDatePublished());

            postService.savePost(currentPost);
            return new ResponseEntity<Post>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
        try {
            Post currentPost = postService.getPostById(id);
            postService.deletePost(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
