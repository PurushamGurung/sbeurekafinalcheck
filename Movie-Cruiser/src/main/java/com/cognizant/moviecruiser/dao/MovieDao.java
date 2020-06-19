package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.NotActiveException;
import com.cognizant.moviecruiser.model.Movie;


public interface MovieDao {
	//view all the movie of List
	public ArrayList<Movie> getMovieListCustomer();
	
	//to find a movie to edit
	public Movie getMovie(long id) throws MovieNotFoundException;

	//to edit the details of movie
	public void modifyMovieDetails(Movie movie) throws MovieNotFoundException;
	
	//to get all active movies
	public ArrayList<Movie> getActiveAndNotInFutureMovies()throws NotActiveException;
}
