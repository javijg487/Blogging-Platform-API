package com.roadmap.blogproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roadmap.blogproject.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrCategoryContainingIgnoreCase(String title, String content, String category);

}
