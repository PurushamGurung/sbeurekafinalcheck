package com.cognizant.moviecruiser.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.exception.CartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotFoundException;
import com.cognizant.moviecruiser.model.Cart;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addToCart(String user, long id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = null;
		movie = movieDao.getMovie(id);
		if (movie == null)
			throw new MovieNotFoundException("Movie with id " + id + " mot found");
		else {
			if (userCarts.containsKey(user)) {
				List<Movie> list = userCarts.get(user).getMovieList();
				list.add(movie);
			} else {
				Cart cart = new Cart();
				cart.getMovieList().add(movie);
				userCarts.put(user, cart);
			}
		}
	}

	@Override
	public HashMap<List<Movie>, Long> getAllMovies(String userId) throws UserNotFoundException, CartEmptyException {
		// TODO Auto-generated method stub
		long total=0;
		if(userCarts.containsKey(userId)) {
			List<Movie> list=userCarts.get(userId).getMovieList();
			total=list.size();
			if(total==0)
				throw new CartEmptyException("Your Cart is Empty");
			userCarts.get(userId).setTotal(total);
			HashMap<List<Movie>,Long> hm=new HashMap<>();
			hm.put(list, total);
			return hm;
		}
		else
			throw new UserNotFoundException("User with id: "+userId+" Not Found ");
	}
	
	@Override
	public void deleteCartItem(String userId, long movieId) throws UserNotFoundException, CartEmptyException, MovieNotFoundException {
		if(userCarts.size()==0)
			throw new UserNotFoundException();
		if(userCarts.containsKey(userId)) {
			
			List<Movie> movieList = userCarts.get(userId).getMovieList();
			if (movieList.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			} 
			boolean deleted=false;
			for (int i = 0; i < movieList.size(); i++) {
				if (movieList.get(i).getId() == movieId) {
					movieList.remove(i);
					deleted=true;
					break;
				}
			}
			if(!deleted)
				throw new MovieNotFoundException("Movie with menuItemId "+movieId+" does not exists for User with userId "+ userId);
		}else
			throw new UserNotFoundException("User with userid "+userId+" does not exist");
		
	}
	
	//getCartItem,deleteCartItem

}
