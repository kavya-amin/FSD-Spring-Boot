package com.example.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
