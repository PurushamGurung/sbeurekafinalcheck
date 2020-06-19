package com.cognizant.moviecruiser.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.moviecruiser.dao.CartDao;
import com.cognizant.moviecruiser.exception.CartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public void addToCart(String user, long id) throws MovieNotFoundException {
		cartDao.addToCart(user, id);
	}

	public HashMap<List<Movie>, Long> getAllMovies(String userId) throws UserNotFoundException, CartEmptyException {
		return cartDao.getAllMovies(userId);
	}

	public void deleteCartItem(String userId, long menuItemId)
			throws UserNotFoundException, CartEmptyException, MovieNotFoundException {
		cartDao.deleteCartItem(userId, menuItemId);
	}
}
