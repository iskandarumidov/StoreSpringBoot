package com.moviecraze.store.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.moviecraze.store.jsonviews.Views;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityReference(alwaysAsId=true)
public class Actor {
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	@ManyToMany(mappedBy = "actors")
	@JsonBackReference
//	@JsonView(Views.ActorHideMoviePojos.class)
	private Set<Movie> movies;
	
//	@Transient
//	@Autowired
//	@JsonView(Views.ActorHideMovieIds.class)
//	private List<Long> movieIds = new ArrayList<>();
	protected Actor() {
		
	}
	public Actor(String firstName, String lastName, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
//		this.movies = movies;
		
	}
	
	@JsonProperty
	public List<Long> getParentId() {
		
		if(movies.size() == 0) {
			return null;
		}else {
			List<Long> idList= new ArrayList<>();
			for(Movie movie : movies) {
				idList.add(movie.getId());
			}
			return idList;
		}
	}	
	
	
//	public void setMovieIdsFromPojos() {
//		for(Movie movie : movies) {
//			movieIds.add(movie.getId());
//		}
//	}
	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
//	public List<Long> getMovieIds() {
//		return movieIds;
//	}
//	public void setMovieIds(List<Long> movieIds) {
//		this.movieIds = movieIds;
//	}
	
	
}
