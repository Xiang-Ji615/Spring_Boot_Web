package main.java.sharon.movieuploader.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import main.java.sharon.movieuploader.model.Movie;

public interface ICsvReader {

	List<Movie> getMovies(MultipartFile uploadFile) throws IOException;
}
