package com.moviecraze.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviecraze.store.entity.Movie;
import com.moviecraze.store.service.MovieRepository;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping
	public List<Movie> getMovies(){
		return movieRepository.findAll();
	}
	
	@GetMapping(params = "name")
	public List<Movie> getUsersByName(@RequestParam("name") String name){
		return movieRepository.findByNameContainingIgnoreCase(name);
	}
	
//	@GetMapping(params = "name")
//	@ResponseBody
//	public String getAttr(@RequestParam("name") String name) {
//		return name;
//	}
	
}
