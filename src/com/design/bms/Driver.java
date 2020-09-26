package com.design.bms;

import com.design.bms.models.Movie;
import com.design.bms.models.MovieShow;
import com.design.bms.models.SeatType;
import com.design.bms.models.TheatreLocation;
import com.design.bms.models.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Driver {
  public static void main(String[] args) {
    BMSManager bmsManager = new BMSManager();
    bmsManager.addUser(new User("u1", "username", "user1@gmail.com", "1231231233"));

    TheatreLocation theatreLocation1 = new TheatreLocation("Hyderabad", "TS", "India", 500090);
    TheatreLocation theatreLocation2 = new TheatreLocation("Chennai", "TN", "India", 600090);
    bmsManager.addNewTheater("th1", "PVR", theatreLocation1);
    bmsManager.addNewTheater("th2", "INOX", theatreLocation2);

    MovieShow show1 = new MovieShow("sh1", new Date(), new Date(), 120);
    MovieShow show2 = new MovieShow("sh2", new Date(), new Date(), 120);

    List<MovieShow> movieShows = new ArrayList<>();
    movieShows.add(show1);
    movieShows.add(show2);
    bmsManager.assignShowsToTheaters(movieShows, "th1");

    Movie movie1 = new Movie("SSR-1", "mov1", new Date(), "COMEDY", 120);
    Movie movie2 = new Movie("SSR-2", "mov2", new Date(), "COMEDY", 120);

    bmsManager.addMovies(movie1);
    bmsManager.addMovies(movie2);

    bmsManager.assignMoviesToTheaters("mov1", "th1");
    bmsManager.assignMoviesToTheaters("mov2", "th1");
    bmsManager.assignMoviesToTheaters("mov2", "th2");

    // search by city
//    bmsManager.searchByCity("Chennai");

    // display shows of movie
//    bmsManager.displayMovieShows("Hyderabad", "mov1");

    // create seats.
    show1.createSeat(SeatType.REGULAR, 1, 1, 150);
    show1.createSeat(SeatType.REGULAR, 1, 2, 150);
    show1.createSeat(SeatType.RECLINER, 1, 3, 250);
    show1.createSeat(SeatType.RECLINER, 1, 4, 250);
    show1.createSeat(SeatType.SOFA, 1, 5, 350);

    // display available seats
    bmsManager.displayAvailableSeats("th2","sh1");
  }
}
