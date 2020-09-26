package com.design.bms.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieShow {
  private String showId;
  private Date showStartTime;
  private Date showEndTime;
  private Integer showDurationInMinutes;
  private List<Seat> seats;

  public MovieShow(
      String showId, Date showStartTime, Date showEndTime, Integer showDurationInMinutes) {
    this.showId = showId;
    this.showStartTime = showStartTime;
    this.showEndTime = showEndTime;
    this.showDurationInMinutes = showDurationInMinutes;
    this.seats = new ArrayList<>();
  }

  public String getShowId() {
    return showId;
  }

  public void setShowId(String showId) {
    this.showId = showId;
  }

  public Date getShowStartTime() {
    return showStartTime;
  }

  public void setShowStartTime(Date showStartTime) {
    this.showStartTime = showStartTime;
  }

  public Date getShowEndTime() {
    return showEndTime;
  }

  public void setShowEndTime(Date showEndTime) {
    this.showEndTime = showEndTime;
  }

  public Integer getShowDurationInMinutes() {
    return showDurationInMinutes;
  }

  public void setShowDurationInMinutes(Integer showDurationInMinutes) {
    this.showDurationInMinutes = showDurationInMinutes;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void setSeats(List<Seat> seats) {
    this.seats = seats;
  }

  public void createSeat(SeatType seatType, int rowNumber, int serialNo, double price) {
    Seat seat = new Seat(rowNumber, serialNo, seatType, price);
    this.seats.add(seat);
  }
}
