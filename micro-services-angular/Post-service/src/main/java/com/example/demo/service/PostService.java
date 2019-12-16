package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public List<Post> listAllPosts()
	{
		return postRepository.findAll();
	}
	}
