package com.moviecraze.store.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	private int budget;
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "Movie_Actor",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	private Set<Actor> actors;
	private String country;
	private String ageRating;
	private int lengthInMinutes;
	
	protected Movie() {
		
	}
	
	public Movie(String name, Date releaseDate, int budget, String country, String rating,
			int lengthInMinutes) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.budget = budget;
//		this.actors = actors;
		this.country = country;
		this.ageRating = rating;
		this.lengthInMinutes = lengthInMinutes;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public int getBudget() {
		return budget;
	}

	public String getCountry() {
		return country;
	}

	public long getId() {
		return id;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public String getName() {
		return name;
	}

	public String getRating() {
		return ageRating;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLengthInMinutes(int lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRating(String rating) {
		this.ageRating = rating;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", country=" + country + ", lengthInMinutes=" + lengthInMinutes
				+ "]";
	}
	
	
}
