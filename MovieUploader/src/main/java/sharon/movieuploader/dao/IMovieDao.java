package main.java.sharon.movieuploader.dao;

import main.java.sharon.movieuploader.model.Movie;

public interface IMovieDao {
	Boolean saveMovie(Movie movie);
	
	Boolean deleteAllMovie();
}
