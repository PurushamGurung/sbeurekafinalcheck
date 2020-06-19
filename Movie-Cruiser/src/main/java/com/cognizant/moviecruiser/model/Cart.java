package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cart {
	private List<Movie> movieList;

	private long total;

	private static final Logger LOGGER = LoggerFactory.getLogger(Cart.class);

	public Cart() {
		LOGGER.info("Inside Cart Constructor");
		movieList=new ArrayList<Movie>();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	
}
