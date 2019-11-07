package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jpa.dao.AlbumRepository;
import com.example.jpa.entity.Album;
import com.example.jpa.entity.Image;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;
	
	
	public AlbumServiceImpl(AlbumRepository albumrepository) {
		super();
		this.albumRepository = albumrepository;
	}


	@Override
	public void createAlbum(Album album) {
		
		albumRepository.save(album);
		
	}


	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		return albumRepository.findAll();
	}


	@Override
	public Optional<Album> getAlbumById(int theId) {
		// TODO Auto-generated method stub
		Optional<Album> album = albumRepository.findById(theId);
		return album;
	}


	

}
