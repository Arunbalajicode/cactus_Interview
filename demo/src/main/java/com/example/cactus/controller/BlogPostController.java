package com.example.cactus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cactus.model.BlogPost;
import com.example.cactus.service.BlogPostService;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

 @Autowired
 private BlogPostService blogPostService;

 @GetMapping
 public ResponseEntity<List<BlogPost>> getAllPosts() {
     List<BlogPost> posts = blogPostService.getAllPosts();
     return ResponseEntity.ok(posts);
 }

 @GetMapping("/{id}")
 public ResponseEntity<BlogPost> getPostById(@PathVariable Long id) {
     Optional<BlogPost> post = blogPostService.getPostById(id);
     return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 @PostMapping
 public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
     BlogPost createdPost = blogPostService.createPost(post);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
 }

 @PutMapping("/{id}")
 public ResponseEntity<BlogPost> updatePost(@PathVariable Long id, @RequestBody BlogPost post) {
     BlogPost updatedPost = blogPostService.updatePost(id, post);
     return ResponseEntity.ok(updatedPost);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deletePost(@PathVariable Long id) {
     blogPostService.deletePost(id);
     return ResponseEntity.noContent().build();
 }
}
