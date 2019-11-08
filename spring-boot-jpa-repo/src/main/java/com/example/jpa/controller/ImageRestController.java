package com.example.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Image;
import com.example.jpa.service.ImageService;


@RestController
@RequestMapping("/")
public class ImageRestController {
	
	private ImageService imageService;

	public ImageRestController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/images")
	public Image createImage(@RequestBody Image image) {
		imageService.createImage(image);
		return image;
	}
	
	@RequestMapping("/images")
	public List<Image> getAllImages(){
		return imageService.getAllImages();
	}
	
	@GetMapping("/images/{id}")
	public Optional<Image> getImageById(@PathVariable int id){
		Optional<Image> image = imageService.getImageById(id);
		return image;
	}
}
