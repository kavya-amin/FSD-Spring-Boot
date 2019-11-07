package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import com.example.jpa.entity.Album;
import com.example.jpa.entity.Image;

public interface AlbumService {
	
	public void createAlbum(Album album);
	public List<Album> getAllAlbums();
	public Optional<Album> getAlbumById(int theId);
}
