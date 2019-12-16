package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("api/")
public class PostController {
	@Autowired
	private PostService postService;


	@PostMapping(value = "/add-todo")
	public Post createPost(@RequestBody Post post) {
	return postService.createPost(post);
		
	}
	
	@GetMapping(value = "/list")
	@ResponseBody
	public List<Post> listAllPosts(){
		return postService.listAllPosts();
	}
}
