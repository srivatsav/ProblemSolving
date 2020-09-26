package com.design.bms.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {

  private String title;
  private String movieId;
  private Date releaseDate;
  private String genre;
  private Integer durationInMinutes;
  private List<MovieTheatre> movieTheatres;

  public Movie(
      String title, String movieId, Date releaseDate, String genre, Integer durationInMinutes) {
    this.title = title;
    this.movieId = movieId;
    this.releaseDate = releaseDate;
    this.genre = genre;
    this.durationInMinutes = durationInMinutes;
    this.movieTheatres = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Integer getDurationInMinutes() {
    return durationInMinutes;
  }

  public void setDurationInMinutes(Integer durationInMinutes) {
    this.durationInMinutes = durationInMinutes;
  }

  public List<MovieTheatre> getMovieTheatres() {
    return movieTheatres;
  }

  public void setMovieTheatres(List<MovieTheatre> movieTheatres) {
    this.movieTheatres = movieTheatres;
  }
}
