package com.example.jpa.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Posts {
	
	private int userId;
	private ObjectId _id;
	private String title;
	private String body;
	public String get_id()
	{
		
		return _id.toHexString();
	}
	

}
