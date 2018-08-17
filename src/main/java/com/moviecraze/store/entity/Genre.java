package com.moviecraze.store.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	
//	@JsonBackReference
	private List<Movie> movies;
	
	protected Genre() {
		
	}
	
	public Genre(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}
	
	
}
