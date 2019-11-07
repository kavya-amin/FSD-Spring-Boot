package com.example.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
