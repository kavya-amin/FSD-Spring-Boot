package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import com.example.jpa.entity.Image;

public interface ImageService {
	
	public void createImage(Image image);
	public List<Image> getAllImages();
	public Optional<Image> getImageById(int theId);

}
