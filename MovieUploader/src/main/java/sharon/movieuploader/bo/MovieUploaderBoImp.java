package main.java.sharon.movieuploader.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import main.java.sharon.movieuploader.dao.ICsvReader;
import main.java.sharon.movieuploader.dao.IMovieDao;
import main.java.sharon.movieuploader.model.Movie;

@Component
public class MovieUploaderBoImp implements IMovieUploaderBo {
	
	@Autowired
	ICsvReader csvReader;
	
	@Autowired
	IMovieDao movieDao;
	
	@Override
	public Boolean uploadFile(MultipartFile uploadfile) throws IOException {
		List<Movie> movies = csvReader.getMovies(uploadfile);
		for(Movie movie : movies){
			movieDao.saveMovie(movie);
		}
		return true;
	}

}
