package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.NotActiveException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieDaoCollectionImpl implements MovieDao {

	private static ArrayList<Movie> movieList;
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("movies.xml");
		movieList = (ArrayList<Movie>) context.getBean("movieList");
	}

	@Override
	public ArrayList<Movie> getMovieListCustomer() {
		return movieList;
	}

	@Override
	public Movie getMovie(long id) throws MovieNotFoundException {
		Movie movie = null;
		for (Movie m : movieList) {
			if (m.getId() == id) {
				movie = m;
				break;
			}
		}
		if (movie == null)
			throw new MovieNotFoundException("Movie of Id " + id + " Not Found");
		return movie;
	}

	@Override
	public void modifyMovieDetails(Movie movie) throws MovieNotFoundException {
		int pos = 0;
		Movie mfnd = null;
		for (Movie m : movieList) {
			if (m.getId() == movie.getId()) {
				mfnd = m;
				break;
			}
			pos++;
		}
		if (mfnd == null)
			throw new MovieNotFoundException("Movie with id : " + movie.getId() + "Not Found");
		else {
			movieList.set(pos, movie);
		}
	}

	@Override
	public ArrayList<Movie> getActiveAndNotInFutureMovies() throws NotActiveException {
		ArrayList<Movie> active = new ArrayList<Movie>();
		Date current = new Date(System.currentTimeMillis());
		for (Movie m : movieList) {
			if (m.isActive() && current.after(m.getDateOfLaunch()))
				active.add(m);
		}
		if (active.size() == 0)
			throw new NotActiveException("not Active");
		return active;
	}

}
