package com.design.hotel.entities;

import java.util.List;

public class Hotel {

  private long hotelId;
  private String hotelName;
  private List<HotelLocation> hotelLocations;
  private List<Room> availableRooms;

  public long getHotelId() {
    return hotelId;
  }

  public void setHotelId(long hotelId) {
    this.hotelId = hotelId;
  }

  public String getHotelName() {
    return hotelName;
  }

  public void setHotelName(String hotelName) {
    this.hotelName = hotelName;
  }

  public List<HotelLocation> getHotelLocations() {
    return hotelLocations;
  }

  public void setHotelLocations(List<HotelLocation> hotelLocations) {
    this.hotelLocations = hotelLocations;
  }

  public List<Room> getAvailableRooms() {
    return availableRooms;
  }

  public void setAvailableRooms(List<Room> availableRooms) {
    this.availableRooms = availableRooms;
  }

  public boolean addHotelLocation(HotelLocation location) {
    return true;
  }
}
