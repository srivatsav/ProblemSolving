package com.design.hotel.service;

import com.design.hotel.entities.Hotel;
import com.design.hotel.entities.Room;
import com.design.hotel.enums.RoomType;
import java.util.Date;
import java.util.List;

public interface HotelBookingService {

  List<Room> searchRooms(RoomType roomType,Date checkInDate, Date checkoutDate);
}
