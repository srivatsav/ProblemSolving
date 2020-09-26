package com.design.bms;

import com.design.bms.models.Movie;
import com.design.bms.models.MovieShow;
import com.design.bms.models.MovieTheatre;
import com.design.bms.models.Seat;
import com.design.bms.models.TheatreLocation;
import com.design.bms.models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BMSManager {

  List<Movie> movies;
  Map<Integer, Map<Integer, Boolean>> seatAvailability;
  Map<String, MovieTheatre> movieTheaterMap;
  Map<String, User> userMap;
  Map<String, List<Movie>> cityMap;
  Map<String, List<Movie>> genreMap;
  Map<String, Movie> titleMap;

  BMSManager() {
    this.movies = new ArrayList<>();
    this.seatAvailability = new HashMap<>();
    this.userMap = new HashMap<>();
    this.movieTheaterMap = new HashMap<>();
    this.cityMap = new HashMap<>();
    this.genreMap = new HashMap<>();
    this.titleMap = new HashMap<>();
  }

  public void addUser(User user) {
    userMap.put(user.getUserId(), user);
  }

  public void addNewTheater(String theaterId, String theaterName, TheatreLocation theaterLocation) {
    MovieTheatre theater = new MovieTheatre(theaterId, theaterName, theaterLocation);
    movieTheaterMap.put(theaterId, theater);
  }

  public void addMovies(Movie movie) {
    this.movies.add(movie);
    // save the movie by title
    titleMap.put(movie.getTitle(), movie);
    // save the movie by genre.
    if (!genreMap.containsKey(movie.getGenre())) {
      genreMap.put(movie.getGenre(), new ArrayList<>());
    }
    genreMap.get(movie.getGenre()).add(movie);
  }

  public void assignShowsToTheaters(List<MovieShow> movieShows, String theatreId) {
    MovieTheatre theatre = movieTheaterMap.get(theatreId);
    theatre.getMovieShows().addAll(movieShows);
  }

  public void assignMoviesToTheaters(String movieId, String theatreId) {
    Movie filteredMovie =
        movies.stream().filter(movie -> movie.getMovieId().equals(movieId)).findFirst().get();
    MovieTheatre theatre = movieTheaterMap.get(theatreId);
    filteredMovie.getMovieTheatres().add(theatre);
    // save the movie in city map.
    for (MovieTheatre theater : filteredMovie.getMovieTheatres()) {
      String city = theater.getTheatreLocation().getCity();
      if (!cityMap.containsKey(city)) {
        cityMap.put(city, new ArrayList<>());
      }
      cityMap.get(city).add(filteredMovie);
    }
  }

  public List<Movie> searchByCity(String city) {
    if (!cityMap.containsKey(city)) {
      System.out.println("NO CITY FOUND");
      return null;
    }
    List<Movie> movies = cityMap.get(city);
    if (movies.isEmpty()) {
      System.out.println("NO MOVIES IN THIS CITY");
      return null;
    }
    for (Movie movie : movies) {
      System.out.println("Movie Title :: " + movie.getTitle());
    }
    return movies;
  }

  public void displayMovieShows(String cityId, String movieId) {
    List<Movie> movies = searchByCity(cityId);
    Optional<Movie> movieOptional =
        movies.stream().filter(movie -> movie.getMovieId().equals(movieId)).findFirst();
    if (movieOptional.isEmpty()) {
      System.out.println("MOVIE NOT FOUND");
      return;
    }
    Movie movie = movieOptional.get();
    for (MovieTheatre theatre : movie.getMovieTheatres()) {
      for (MovieShow show : theatre.getMovieShows()) {
        System.out.println(
            "Theatre Name -- "
                + theatre.getTheatreName()
                + " Show Start Time -- "
                + show.getShowStartTime()
                + " Show End Time -- "
                + show.getShowEndTime());
      }
    }
  }

  public void displayAvailableSeats(String theatreId, String showId) {
    if (!movieTheaterMap.containsKey(theatreId)) {
      System.out.println("THEATER NOT FOUND");
      return;
    }
    MovieTheatre movieTheatre = movieTheaterMap.get(theatreId);
    Optional<MovieShow> showOptional =
        movieTheatre.getMovieShows().stream()
            .filter(show -> show.getShowId().equals(showId))
            .findFirst();
    if (showOptional.isEmpty()) {
      System.out.println("SHOW NOT FOUND");
      return;
    }
    MovieShow movieShow = showOptional.get();
    List<Seat> showSeats =
        movieShow.getSeats().stream()
            .filter(seat -> seat.isSeatAvailable() == true)
            .collect(Collectors.toList());

    if (showSeats.isEmpty()) {
      System.out.println("NO SETS FOUND");
      return;
    }

    for (Seat seat : showSeats) {
      System.out.println(
          "SEAT -- "
              + seat.getRowNumber()
              + "--"
              + seat.getSerialNumber()
              + " -- "
              + seat.getSeatType()
              + " -- "
              + seat.getPrice());
    }
  }
}
