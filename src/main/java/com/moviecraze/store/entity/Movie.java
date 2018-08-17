package com.moviecraze.store.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	private int budget;
//	@JsonManagedReference
//	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
//    @JoinTable(name = "Movie_Actor",
//            joinColumns = { @JoinColumn(name = "movie_id") },
//            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
//	private Set<Actor> actors;
	
	
	@OneToMany(mappedBy = "movie")
	private Set<ActorMovieGenreLink> actorMovieGenreLinks;

	
	
	
	private String country;
	private String ageRating;
	private int lengthInMinutes;
	
	
	//This piece of code would only provide a list of Actor IDs, not the actual objects
//	@JsonProperty
//	public List<Long> getActorIds() {
//		
//		if(actorMovieGenreLinks.size() == 0) {
//			return null;
//		}else {
//			List<Long> idList= new ArrayList<>();
//			for(ActorMovieGenreLink link : actorMovieGenreLinks) {
//				idList.add(link.getActor().getId());
//			}
//			return idList;
//		}
//	}	
	
	@JsonProperty
	public List<Actor> getActors() {
		
		if(actorMovieGenreLinks.size() == 0) {
			return null;
		}else {
			List<Actor> actList= new ArrayList<>();
			for(ActorMovieGenreLink link : actorMovieGenreLinks) {
				actList.add(link.getActor());
			}
			return actList;
		}
	}	
	
	@JsonProperty
	public List<Genre> getGenres() {
		
		if(actorMovieGenreLinks.size() == 0) {
			return null;
		}else {
			List<Genre> genreList= new ArrayList<>();
			for(ActorMovieGenreLink link : actorMovieGenreLinks) {
				genreList.add(link.getGenre());
			}
			return genreList;
		}
	}	
	
	
	
	
	protected Movie() {
		
	}
	
	public Movie(String name, Date releaseDate, int budget, String country, String rating,
			int lengthInMinutes) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.country = country;
		this.ageRating = rating;
		this.lengthInMinutes = lengthInMinutes;
	}

//	public Set<Actor> getActors() {
//		return actors;
//	}

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

//	public void setActors(Set<Actor> actors) {
//		this.actors = actors;
//	}

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
