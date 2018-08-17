package com.moviecraze.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ActorMovieGenreLink {
	
	@Id
	@GeneratedValue
	private long id;	//change to Long?
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "actor_id")
	private Actor actor;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "genre_id")
	private Genre genre;

	protected ActorMovieGenreLink() {
		
	}

	public ActorMovieGenreLink(Actor actor, Movie movie, Genre genre) {
		super();
		this.actor = actor;
		this.movie = movie;
		this.genre = genre;
	}

	public Actor getActor() {
		return actor;
	}

	public Genre getGenre() {
		return genre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "ActorMovieGenreLink [id=" + id + ", actor=" + actor + ", movie=" + movie + ", genre=" + genre + "]";
	}
	
	
	
	
}
