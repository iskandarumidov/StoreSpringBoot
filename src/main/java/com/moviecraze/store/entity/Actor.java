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

@Entity
public class Actor {
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
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
	
//	@JsonProperty
//	public List<Long> getParentId() {
//		
//		if(movies.size() == 0) {
//			return null;
//		}else {
//			List<Long> idList= new ArrayList<>();
//			for(Movie movie : movies) {
//				idList.add(movie.getId());
//			}
//			return idList;
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
