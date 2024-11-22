package com.roadmap.blogproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.roadmap.blogproject.models.Post;
import com.roadmap.blogproject.services.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(@RequestParam(required = false) String term) {
        return postService.getAllPosts(term);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        Post post = new Post();
        post = postService.getPostById(id);
        return post;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Post post = new Post();
        post = postService.updatePost(id, postDetails);
        return post;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
