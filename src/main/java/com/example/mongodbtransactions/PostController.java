package com.example.mongodbtransactions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> posts() {
        return  postService.getAllPosts();
    }

    @GetMapping("/add")
    public String add() {
        postService.addPost(new Post("test", "content"));
        return "added";
    }

    @GetMapping("/bad")
    public String bad() {
        postService.createPost(new Post("test", "content"));
        return "added";
    }
}
