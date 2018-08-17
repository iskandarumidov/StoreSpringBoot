package com.moviecraze.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecraze.store.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
