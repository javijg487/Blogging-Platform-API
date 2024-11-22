package com.roadmap.blogproject.services;

import java.util.List;


import com.roadmap.blogproject.models.Post;

public interface PostService {
    List<Post> getAllPosts(String term);

    Post getPostById(Long id);

    Post createPost(Post post);

    Post updatePost(Long id, Post postDetails);

    void deletePost(Long id);
}
