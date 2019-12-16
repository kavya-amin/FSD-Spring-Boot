package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.model.Posts;
import com.example.jpa.service.PostsService;

@RestController
@RequestMapping("/api")
public class PostsController {
	@Autowired
	private PostsService postsService;
	
	@GetMapping("/posts")
	public List<Posts> getAllPosts(){
		return postsService.getAllPosts();
	}
	
	@PostMapping("/posts")
	public Posts createPosts(@RequestBody Posts posts) {
		return postsService.createPosts(posts);
	}

}
