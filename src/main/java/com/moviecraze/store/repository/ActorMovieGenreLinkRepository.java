package com.moviecraze.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecraze.store.entity.ActorMovieGenreLink;

public interface ActorMovieGenreLinkRepository extends JpaRepository<ActorMovieGenreLink, Long>{

}
