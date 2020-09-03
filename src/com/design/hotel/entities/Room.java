package com.design.hotel.entities;

import com.design.hotel.enums.RoomStatus;
import com.design.hotel.enums.RoomType;
import com.design.hotel.service.HotelBookingService;
import java.util.Date;
import java.util.List;

public class Room implements HotelBookingService {

  private long roomNumber;
  private List<String> amenities;
  private long bookingPrice;
  private RoomType roomType;
  private RoomStatus roomStatus;

  public long getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(long roomNumber) {
    this.roomNumber = roomNumber;
  }

  public List<String> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<String> amenities) {
    this.amenities = amenities;
  }

  public long getBookingPrice() {
    return bookingPrice;
  }

  public void setBookingPrice(long bookingPrice) {
    this.bookingPrice = bookingPrice;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(RoomType roomType) {
    this.roomType = roomType;
  }

  public RoomStatus getRoomStatus() {
    return roomStatus;
  }

  public void setRoomStatus(RoomStatus roomStatus) {
    this.roomStatus = roomStatus;
  }

  @Override
  public List<Room> searchRooms(RoomType roomType, Date checkInDate, Date checkoutDate) {
    return null;
  }
}
