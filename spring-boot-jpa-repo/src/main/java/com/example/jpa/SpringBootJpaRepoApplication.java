package com.example.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.jpa.dao.AlbumRepository;
import com.example.jpa.dao.ImageRepository;
import com.example.jpa.entity.Album;
import com.example.jpa.entity.Image;

@SpringBootApplication
public class SpringBootJpaRepoApplication {
	
	private AlbumRepository albumRepository;
	private ImageRepository imageRepository;
	
	

	public SpringBootJpaRepoApplication(AlbumRepository albumRepository, ImageRepository imageRepository) {
		super();
		this.albumRepository = albumRepository;
		this.imageRepository = imageRepository;
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRepoApplication.class, args);
	}
	
	/**@Component
	class ImageCommand implements CommandLineRunner{
		
		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			List<Image> list = new ArrayList<Image>();
			Album tempAlbum = new Album();
			Image tempImage = new Image();
			tempImage.setType(".jpeg");
			tempImage.setUrl("image.com");
			tempAlbum.setAlbumName("Animals");
			list.add(tempImage);
			tempImage.setAlbum(tempAlbum);
			tempAlbum.setImages(list);
			albumRepository.save(tempAlbum);
			imageRepository.save(tempImage);
		}
		
	}**/

}
