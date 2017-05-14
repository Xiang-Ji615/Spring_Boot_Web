package main.java.sharon.movieuploader.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import main.java.sharon.movieuploader.model.Movie;

@Component
public class CsvReaderImp implements ICsvReader {

	@Override
	public List<Movie> getMovies(MultipartFile uploadFile) throws IOException {

		InputStream inputStream = uploadFile.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		String line;
		int counter = 0;
		String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
		List<Movie> ret = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			if (counter > 0) {
				String[] movieString = line.split(csvSplitBy);
				Movie movie = new Movie();
				movie.setDirectorName(movieString[0]);
				movie.setDuration(!movieString[1].equals("") ? Integer.valueOf(movieString[1]) : 0);
				movie.setGross(!movieString[2].equals("") ? Integer.valueOf(movieString[2]) : 0);
				movie.setActor1Name(movieString[3]);
				movie.setMovieTitle(movieString[4]);
				movie.setNumVotedUsers(!movieString[5].equals("") ? Integer.valueOf(movieString[5]) : 0);
				movie.setLanguage(movieString[6]);
				movie.setCountry(movieString[7]);
				movie.setBuget(!movieString[8].equals("")? Double.valueOf(movieString[8]) : 0);
				movie.setTitleYear(!movieString[9].equals("") ? Integer.valueOf(movieString[9]) : 0);
				movie.setImdbScore(!movieString[10].equals("") ? Double.valueOf(movieString[10]) : 0);
				movie.setGenres1(getGenres(movieString, 11));
				movie.setGenres2(getGenres(movieString, 12));
				movie.setGenres3(getGenres(movieString, 13));
				movie.setGenres4(getGenres(movieString, 14));
				movie.setGenres5(getGenres(movieString, 15));
				movie.setGenres6(getGenres(movieString, 16));
				movie.setGenres7(getGenres(movieString, 17));
				ret.add(movie);
			}
			counter++;
		}

		return ret;
	}

	public String getGenres(String[] movieString, int position) {
		String ret;
		try {
			ret = movieString[position];
		} catch (Exception e) {
			ret = "";
		}
		return ret;
	}

}
