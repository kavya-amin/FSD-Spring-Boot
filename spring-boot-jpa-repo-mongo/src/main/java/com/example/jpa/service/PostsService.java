package com.example.jpa.service;

import java.util.List;

import com.example.jpa.model.Posts;

public interface PostsService {
	public List<Posts> getAllPosts();
	public Posts createPosts(Posts posts);
}
