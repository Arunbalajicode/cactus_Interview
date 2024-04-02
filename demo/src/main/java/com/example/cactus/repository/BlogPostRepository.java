package com.example.cactus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cactus.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}

