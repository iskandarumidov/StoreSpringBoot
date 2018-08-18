package com.moviecraze.store.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.moviecraze.store.jsonviews.Views;

@Entity
public class Actor {
	@Id
	@GeneratedValue
//	@JsonView(Views.HideMovieActors.class)
	private long id;
	
//	@JsonView(Views.HideMovieActors.class)
	private String firstName;
	
//	@JsonView(Views.HideMovieActors.class)
	private String lastName;
	
//	@JsonView(Views.HideMovieActors.class)
	private Date dateOfBirth;
//	@ManyToMany(mappedBy = "actors")
//	@JsonBackReference
//	private Set<Movie> movies;

//	@JsonBackReference
	@OneToMany(mappedBy = "actor")
	private Set<ActorMovieGenreLink> actorMovieGenreLinks;
	
	protected Actor() {
		
	}
	public Actor(String firstName, String lastName, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	@JsonProperty
//	@JsonView(Views.HideMovieActors.class)
	public List<Movie> getMovies() {
		
		if(actorMovieGenreLinks.size() == 0) {
			return null;
		}else {
			List<Movie> movies= new ArrayList<>();
			for(ActorMovieGenreLink link : actorMovieGenreLinks) {
				movies.add(link.getMovie());
			}
			return movies;
		}
	}	
	
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
//	public Set<Movie> getMovies() {
//		return movies;
//	}
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
	
//	public void setMovies(Set<Movie> movies) {
//		this.movies = movies;
//	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
}
