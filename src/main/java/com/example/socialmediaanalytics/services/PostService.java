package com.example.socialmediaanalytics.services;

import com.example.socialmediaanalytics.models.Post;
import com.example.socialmediaanalytics.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(String postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found with ID: " + postId));
    }

    public String getPostContentById(String postId) {
        try {
            Post post = getPostById(postId);
            return post.getContent();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Post content not found for ID: " + postId, e);
        }
    }
}