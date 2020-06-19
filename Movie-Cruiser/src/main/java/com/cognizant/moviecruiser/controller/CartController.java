package com.cognizant.moviecruiser.controller;

import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.moviecruiser.exception.CartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotFoundException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	public CartController() {
		LOGGER.info("Inside Cart Controller Construtor");
	}

	@GetMapping("/{userId}")
	public HashMap<List<Movie>, Long> getAllMovies(@PathVariable String userId)
			throws UserNotFoundException, CartEmptyException {
		LOGGER.info("Inside get All movies in Controller");
		HashMap<List<Movie>, Long> mlist = cartService.getAllMovies(userId);
		LOGGER.debug("Movies List: {}, Total :{}", mlist.keySet(), mlist.values());
		return mlist;
	}

	@PostMapping("/{userId}/{id}")
	public void addToCart(@PathVariable String userId, @PathVariable long id) throws MovieNotFoundException {
		LOGGER.info("Inside add to Cart in Controller");
		cartService.addToCart(userId, id);
		LOGGER.info("Added To Cart of User Id " + userId);

	}

	@DeleteMapping("/{userId}/{movieId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long movieId)
			throws UserNotFoundException, CartEmptyException, MovieNotFoundException {
		LOGGER.info("Inside delete Cart Item inside Cart Controller");
		cartService.deleteCartItem(userId, movieId);
		LOGGER.debug("Movie deleted");
	}

}
