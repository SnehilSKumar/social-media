package com.example.socialmediaanalytics.services;

import com.example.socialmediaanalytics.models.Post;
import com.example.socialmediaanalytics.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPost() {
        Post postToCreate = new Post("1", "Sample content");
        when(postRepository.save(postToCreate)).thenReturn(postToCreate);

        Post createdPost = postService.createPost(postToCreate);

        assertNotNull(createdPost);
        assertEquals(postToCreate.getId(), createdPost.getId());
        assertEquals(postToCreate.getContent(), createdPost.getContent());

        verify(postRepository, times(1)).save(postToCreate);
    }

    @Test
    void getPostById() {
        String postId = "1";
        Post mockPost = new Post(postId, "Sample content");
        when(postRepository.findById(postId)).thenReturn(Optional.of(mockPost));

        Post retrievedPost = postService.getPostById(postId);

        assertNotNull(retrievedPost);
        assertEquals(mockPost.getId(), retrievedPost.getId());
        assertEquals(mockPost.getContent(), retrievedPost.getContent());

        verify(postRepository, times(1)).findById(postId);
    }

    @Test
    void getPostContentById() {
        String postId = "1";
        Post mockPost = new Post(postId, "Sample content");
        when(postRepository.findById(postId)).thenReturn(Optional.of(mockPost));

        String postContent = postService.getPostContentById(postId);

        assertNotNull(postContent);
        assertEquals(mockPost.getContent(), postContent);

        verify(postRepository, times(1)).findById(postId);
    }
}
