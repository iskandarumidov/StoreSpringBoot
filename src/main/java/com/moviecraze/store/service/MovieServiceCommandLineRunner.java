package com.moviecraze.store.service;

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
	private ActorRepository actorService;
	
	@Override
	public void run(String... args) throws Exception {
//		mlog.info("New user: " + user);
		//months start at 0
		Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
		Date myDate = myCalendar.getTime();
		
		Actor actor1 = new Actor("Adam", "Pirogov", new Date(1978, 7, 6));
		Actor actor2 = new Actor("John", "Doe", new Date(1948, 3, 4));
		Actor actor3 = new Actor("Bob", "Black", new Date(1948, 3, 4));
		Actor actor4 = new Actor("Marty", "Dlack", new Date(1948, 3, 4));
		
		actorService.save(actor1);
		actorService.save(actor2);
		actorService.save(actor3);
		actorService.save(actor4);
		
		
		Set<Actor> movie1Actors = new HashSet<>();
		Set<Actor> movie2Actors = new HashSet<>();
		movie1Actors.add(actor1);
		movie1Actors.add(actor2);
		
		movie2Actors.add(actor1);
		movie2Actors.add(actor3);
		movie2Actors.add(actor4);
		


		Movie movie1 = new Movie("Deadly Mouse", myDate, 12000000, "US", "R", 120);
		Movie movie2 = new Movie("Healthy Elephant", myDate, 12000000, "UK", "R", 150);
		movie1.setActors(movie1Actors);
		movie2.setActors(movie2Actors);
//		actorRepository.save(actor1);
//		actorRepository.save(actor2);
		movieRepository.save(movie1);
		movieRepository.save(movie2);

		
	}

}
