package com.design.bms.models;

import java.util.ArrayList;
import java.util.List;

public class MovieTheatre {
  private String theatreId;
  private String theatreName;
  private TheatreLocation theatreLocation;
  private List<MovieShow> movieShows;

  public MovieTheatre(String theatreId, String theatreName, TheatreLocation theatreLocation) {
    this.theatreId = theatreId;
    this.theatreName = theatreName;
    this.theatreLocation = theatreLocation;
    this.movieShows = new ArrayList<>();
  }

  public String getTheatreId() {
    return theatreId;
  }

  public void setTheatreId(String theatreId) {
    this.theatreId = theatreId;
  }

  public String getTheatreName() {
    return theatreName;
  }

  public void setTheatreName(String theatreName) {
    this.theatreName = theatreName;
  }

  public TheatreLocation getTheatreLocation() {
    return theatreLocation;
  }

  public void setTheatreLocation(TheatreLocation theatreLocation) {
    this.theatreLocation = theatreLocation;
  }

  public List<MovieShow> getMovieShows() {
    return movieShows;
  }

  public void setMovieShows(List<MovieShow> movieShows) {
    this.movieShows = movieShows;
  }
}
