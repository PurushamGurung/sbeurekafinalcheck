package com.cognizant.moviecruiser.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.exception.CartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface CartDao {
	
	//make movie favourite Or add to its watchlist
	void addToCart(String user, long id) throws MovieNotFoundException; 
	
	HashMap<List<Movie>,Long> getAllMovies(String userId) throws UserNotFoundException, CartEmptyException;

	void deleteCartItem(String userId, long movieId)
			throws UserNotFoundException, CartEmptyException, MovieNotFoundException;
}
