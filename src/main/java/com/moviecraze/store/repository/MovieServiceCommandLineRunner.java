package com.moviecraze.store.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.moviecraze.store.entity.Actor;
import com.moviecraze.store.entity.ActorMovieGenreLink;
import com.moviecraze.store.entity.Genre;
//import com.moviecraze.store.entity.Actor;
import com.moviecraze.store.entity.Movie;

//Launches at the start of the application
@Component
public class MovieServiceCommandLineRunner implements CommandLineRunner{
	public static final Logger log = LoggerFactory.getLogger(MovieServiceCommandLineRunner.class);
	
	
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private ActorMovieGenreLinkRepository actorMovieGenreLinkRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//months start at 0
		Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
		Date myDate = myCalendar.getTime();
		
		//Creating Actors
		Actor actor1 = new Actor("Adam", "Pirogov", new Date(1978, 7, 6));
		Actor actor2 = new Actor("John", "Doe", new Date(1948, 3, 4));
		Actor actor3 = new Actor("Bob", "Black", new Date(1948, 3, 4));
		Actor actor4 = new Actor("Marty", "Dlack", new Date(1948, 3, 4));
		
		actorRepository.save(actor1);
		actorRepository.save(actor2);
		actorRepository.save(actor3);
		actorRepository.save(actor4);
		//END Actors
		
		//Creating Genres
		Genre genre1 = new Genre("Drama", "Soo dramatical...");
		Genre genre2 = new Genre("Comedy", "Must be funny");
		Genre genre3 = new Genre("Blockbuster", "Just busting some blocks");
		
		genreRepository.save(genre1);
		genreRepository.save(genre2);
		genreRepository.save(genre3);
		//END Genres
		
		
		
		Set<Actor> movie1Actors = new HashSet<>();
		Set<Actor> movie2Actors = new HashSet<>();
		movie1Actors.add(actor1);
		movie1Actors.add(actor2);
		
		movie2Actors.add(actor1);
		movie2Actors.add(actor3);
		movie2Actors.add(actor4);
		

		//Creating Movies
		Movie movie1 = new Movie("Deadly Mouse", myDate, 12000000, "US", "R", 120);
		Movie movie2 = new Movie("Healthy Elephant", myDate, 12000000, "UK", "R", 150);
		
		movieRepository.save(movie1);
		movieRepository.save(movie2);
		//END Movies
		
		ActorMovieGenreLink link1 = new ActorMovieGenreLink(actor1, movie1, genre1);
		actorMovieGenreLinkRepository.save(link1);
		
		
		
//		movie1.setActors(movie1Actors);
//		movie2.setActors(movie2Actors);
//		actorRepository.save(actor1);
//		actorRepository.save(actor2);


		
	}

}
