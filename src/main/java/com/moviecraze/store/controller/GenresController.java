package com.moviecraze.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviecraze.store.entity.Genre;
import com.moviecraze.store.repository.GenreRepository;
//TODO implement paging, so that when user calls all movies with a specific genre, they get paged list
@RestController
@RequestMapping("/api/v1/genres")
public class GenresController {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping
	public List<Genre> getAllGenres(){
		return genreRepository.findAll();
	}
}
