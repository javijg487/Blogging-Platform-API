package com.roadmap.blogproject.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadmap.blogproject.models.Post;
import com.roadmap.blogproject.repositories.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(String term) {
        if(term != null) {
            return postRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrCategoryContainingIgnoreCase(term, term, term);
        }
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> {
                    return new EntityNotFoundException("Post not found with id: " + id);
                });

        post.setTitle(postDetails.getTitle() == null ? post.getTitle() : postDetails.getTitle());
        post.setContent(postDetails.getContent() == null ? post.getContent() : postDetails.getContent());
        post.setCategory(postDetails.getCategory() == null ? post.getCategory() : postDetails.getCategory());
        post.setTags(postDetails.getTags() == null ? post.getTags() : postDetails.getTags());
        post.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}