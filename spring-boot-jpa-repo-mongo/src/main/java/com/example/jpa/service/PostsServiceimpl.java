package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.jpa.model.Posts;
import com.example.jpa.repository.PostsRepository;

public class PostsServiceimpl implements PostsService {
	@Autowired
	private PostsRepository postsRepository;
	
	public List<Posts> getAllPosts() {
		// TODO Auto-generated method stub
		return postsRepository.findAll();
	}

	@Override
	public Posts createPosts(Posts posts) {
		// TODO Auto-generated method stub
		 
		return postsRepository.save(posts);
	}

}
