package main.java.sharon.movieuploader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;

	@Column(name = "director_name")
	String directorName;

	@Column(name = "duration")
	Integer duration;

	@Column(name = "gross")
	Integer gross;

	@Column(name = "actor_1_name")
	String actor1Name;

	@Column(name = "movie_title")
	String movieTitle;

	@Column(name = "num_voted_users")
	Integer numVotedUsers;

	@Column(name = "language")
	String language;

	@Column(name = "country")
	String country;

	@Column(name = "budget")
	Double buget;

	@Column(name = "title_year")
	Integer titleYear;

	@Column(name = "imdb_score")
	Double imdbScore;

	@Column(name = "genres1")
	String genres1;

	@Column(name = "genres2")
	String genres2;

	@Column(name = "genres3")
	String genres3;

	@Column(name = "genres4")
	String genres4;

	@Column(name = "genres5")
	String genres5;

	@Column(name = "genres6")
	String genres6;

	@Column(name = "genres7")
	String genres7;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getGross() {
		return gross;
	}

	public void setGross(Integer gross) {
		this.gross = gross;
	}

	public String getActor1Name() {
		return actor1Name;
	}

	public void setActor1Name(String actor1Name) {
		this.actor1Name = actor1Name;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Integer getNumVotedUsers() {
		return numVotedUsers;
	}

	public void setNumVotedUsers(Integer numVotedUsers) {
		this.numVotedUsers = numVotedUsers;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getBuget() {
		return buget;
	}

	public void setBuget(Double buget) {
		this.buget = buget;
	}

	public Integer getTitleYear() {
		return titleYear;
	}

	public void setTitleYear(Integer titleYear) {
		this.titleYear = titleYear;
	}

	public Double getImdbScore() {
		return imdbScore;
	}

	public void setImdbScore(Double imdbScore) {
		this.imdbScore = imdbScore;
	}

	public String getGenres1() {
		return genres1;
	}

	public void setGenres1(String genres1) {
		this.genres1 = genres1;
	}

	public String getGenres2() {
		return genres2;
	}

	public void setGenres2(String genres2) {
		this.genres2 = genres2;
	}

	public String getGenres3() {
		return genres3;
	}

	public void setGenres3(String genres3) {
		this.genres3 = genres3;
	}

	public String getGenres4() {
		return genres4;
	}

	public void setGenres4(String genres4) {
		this.genres4 = genres4;
	}

	public String getGenres5() {
		return genres5;
	}

	public void setGenres5(String genres5) {
		this.genres5 = genres5;
	}

	public String getGenres6() {
		return genres6;
	}

	public void setGenres6(String genres6) {
		this.genres6 = genres6;
	}

	public String getGenres7() {
		return genres7;
	}

	public void setGenres7(String genres7) {
		this.genres7 = genres7;
	}

}
