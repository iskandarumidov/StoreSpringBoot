package com.moviecraze.store.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.moviecraze.store.entity.Actor;
//import com.moviecraze.store.entity.ActorMovieIdsOnly;
import com.moviecraze.store.jsonviews.Views;
import com.moviecraze.store.repository.ActorRepository;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorsController {
	@Autowired
	private ActorRepository actorService;
	
	@GetMapping
	@JsonView(Views.HideMovieActors.class)
//	@JsonView(Views.ActorHideMoviePojos.class)
	public List<Actor> getAllActors(){
		List<Actor> actors =  actorService.findAll();
//		System.out.println(actors);
//		for (Actor actor : actors) {
//			actor.setMovieIdsFromPojos();
//			System.out.println();
//		}
		return actors;
	}
	
//	@GetMapping(params = "firstName")
//	public Collection<ActorMovieIdsOnly> getByFirstName(String firstName){
//		return actorService.findByFirstName(firstName);
//	}
}
