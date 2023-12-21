package com.example.socialmediaanalytics.repository;

import com.example.socialmediaanalytics.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
