package com.example.movies.review;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reviews")
public class Review{
	
	@Id
	private ObjectId id;
	private String body;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Review(String body) {
		super();
		this.body = body;
	}
	@Override
	public String toString() {
		return "Review [body=" + body + "]";
	}
	
}