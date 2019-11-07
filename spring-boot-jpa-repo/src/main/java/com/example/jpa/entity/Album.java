package com.example.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "album")
@Data
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "album_name")
	String albumName;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album", cascade = {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Image> images;
}
