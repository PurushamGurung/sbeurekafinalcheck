package com.cognizant.moviecruiser.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.NotActiveException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	public MovieController() {
		LOGGER.info("Inside Movie Controller Constructor");
	}
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ArrayList<Movie> getMovieListCustomer(){
		LOGGER.info("Inside getMovie List of Controller");
		ArrayList<Movie> mlist=movieService.getMovieListCustomer();
		LOGGER.debug("Movie List :: {}",mlist);
		
		return mlist;
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id) throws MovieNotFoundException {
		LOGGER.info("Inside getMovie of Controller");
		Movie movie=movieService.getMovie(id);
		LOGGER.debug("Movie :: {}",movie.toString());
		return movie;
	}
	
	@PutMapping
	public void modifyMovieDetails(@RequestBody Movie movie) throws MovieNotFoundException {
		LOGGER.info("Inside Modify Movie details in Controller" );
		movieService.modifyMovie(movie);
		LOGGER.debug("Update Movie :: {} ",movie);
	}
	
	@GetMapping("/active")
	public ArrayList<Movie> getActiveAndNotInFutureMovies() throws NotActiveException{
		LOGGER.info("Inside Active Movies in Controller");
		ArrayList<Movie> mlist=movieService.getActiveAndNotInFutureMovies();
		LOGGER.debug("Active Movies :: {} ",mlist);
		return mlist;
	}
}
