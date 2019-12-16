package com.example.jpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.jpa.model.Posts;

public interface PostsRepository extends MongoRepository<Posts, String>{

}
