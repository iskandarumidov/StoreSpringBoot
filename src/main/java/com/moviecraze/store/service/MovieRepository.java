package com.moviecraze.store.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecraze.store.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	public List<Movie> findByNameContainingIgnoreCase(String name);
}
