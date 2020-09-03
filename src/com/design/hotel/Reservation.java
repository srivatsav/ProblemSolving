package com.design.hotel;

import com.design.hotel.entities.Room;
import com.design.hotel.enums.BookingStatus;
import com.design.hotel.invoice.Invoice;
import java.util.List;

public class Reservation {

  private long bookingId;
  private List<Room> bookedRooms;
  private long bookingTimestamp;
  private BookingStatus bookingStatus;
  private long bookingAmount;
  private Invoice invoice;

  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public long getBookingId() {
    return bookingId;
  }

  public void setBookingId(long bookingId) {
    this.bookingId = bookingId;
  }

  public List<Room> getBookedRooms() {
    return bookedRooms;
  }

  public void setBookedRooms(List<Room> bookedRooms) {
    this.bookedRooms = bookedRooms;
  }

  public long getBookingTimestamp() {
    return bookingTimestamp;
  }

  public void setBookingTimestamp(long bookingTimestamp) {
    this.bookingTimestamp = bookingTimestamp;
  }

  public BookingStatus getBookingStatus() {
    return bookingStatus;
  }

  public void setBookingStatus(BookingStatus bookingStatus) {
    this.bookingStatus = bookingStatus;
  }

  public long getBookingAmount() {
    return bookingAmount;
  }

  public void setBookingAmount(long bookingAmount) {
    this.bookingAmount = bookingAmount;
  }

  /**
   * Fetching the reservation details.
   * @param reservationId
   * @return
   */
  public Reservation fetchReservationDetails(Long reservationId) {
    return new Reservation();
  }
}
