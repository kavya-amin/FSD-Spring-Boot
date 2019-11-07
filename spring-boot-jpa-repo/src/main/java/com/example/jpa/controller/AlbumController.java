package com.example.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Album;
import com.example.jpa.service.AlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {
	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}
	
	@PostMapping("/albums")
	public Album createAlbum(@RequestBody Album album) {
		albumService.createAlbum(album);
		return album;
	}
	
	@RequestMapping("/albums")
	public List<Album> getAllAlbums(){
		return albumService.getAllAlbums();
	}
	
	@GetMapping("/albums/{id}")
	public Optional<Album> getAlbumById(@PathVariable int id) {
		Optional<Album> album = albumService.getAlbumById(id);
		return album;
	}
}
