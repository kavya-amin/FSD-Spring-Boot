package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jpa.dao.ImageRepository;
import com.example.jpa.entity.Image;

@Service
public class ImageServiceImpl implements ImageService {
	
	private ImageRepository imageRepository;
	
	
	
	public ImageServiceImpl(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	public void createImage(Image image) {
		// TODO Auto-generated method stub
		imageRepository.save(image);
	}

	@Override
	public List<Image> getAllImages() {
		// TODO Auto-generated method stub
		
		return imageRepository.findAll();
	}

	@Override
	public Optional<Image> getImageById(int theId) {
		// TODO Auto-generated method stub
		Optional<Image> image = imageRepository.findById(theId);
		return image;
	}

}
