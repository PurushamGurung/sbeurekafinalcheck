package com.cognizant.moviecruiser.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.NotActiveException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;

	public ArrayList<Movie> getMovieListCustomer() {
		return movieDao.getMovieListCustomer();
	}
	
	public Movie getMovie(long id) throws MovieNotFoundException {
		return movieDao.getMovie(id);
	}
	
	public void modifyMovie(Movie movie) throws MovieNotFoundException
	{
		movieDao.modifyMovieDetails(movie);
	}
	
	public ArrayList<Movie> getActiveAndNotInFutureMovies() throws NotActiveException{
		return movieDao.getActiveAndNotInFutureMovies();
	}
}
