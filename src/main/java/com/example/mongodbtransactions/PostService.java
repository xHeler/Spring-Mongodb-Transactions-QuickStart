package com.example.mongodbtransactions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }
    @Transactional
    public void createPost(Post post) {
        postRepository.save(post);

        if (true) {
            throw new RuntimeException("Error creating post");
        }
        System.out.println("Added post: " + post);
    }

}