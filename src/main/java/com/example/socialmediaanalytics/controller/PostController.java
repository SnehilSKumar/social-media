package com.example.socialmediaanalytics.controller;

import com.example.socialmediaanalytics.models.Post;
import com.example.socialmediaanalytics.services.AnalysisService;
import com.example.socialmediaanalytics.services.PostService;
import com.example.socialmediaanalytics.utils.AnalysisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AnalysisService analysisService;

    @PostMapping("/")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {
            Post createdPost = postService.createPost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable String id) {
        try {
            Post post = postService.getPostById(id);
            return ResponseEntity.ok(post);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @GetMapping("/{id}/analysis")
    public ResponseEntity<?> getPostAnalysis(@PathVariable String id) {
        try {
            Post post = postService.getPostById(id);

            if (post == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }

            AnalysisResult analysisResult = analysisService.analyzePost(post.getContent());
            return ResponseEntity.ok(analysisResult);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    private ResponseEntity<String> handleException(Exception e) {
        // Log the exception for debugging purposes
        e.printStackTrace();

        // Return a generic error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}

