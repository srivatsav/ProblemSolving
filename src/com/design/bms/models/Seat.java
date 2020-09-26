package com.design.bms.models;

public class Seat {
  private int rowNumber;
  private int serialNumber;
  private SeatType seatType;
  private Double price;
  private boolean isSeatAvailable;

  public Seat(int rowNumber, int serialNumber, SeatType seatType, Double price) {
    this.rowNumber = rowNumber;
    this.serialNumber = serialNumber;
    this.seatType = seatType;
    this.price = price;
    this.isSeatAvailable = true;
  }

  public int getRowNumber() {
    return rowNumber;
  }

  public void setRowNumber(int rowNumber) {
    this.rowNumber = rowNumber;
  }

  public int getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(int serialNumber) {
    this.serialNumber = serialNumber;
  }

  public SeatType getSeatType() {
    return seatType;
  }

  public void setSeatType(SeatType seatType) {
    this.seatType = seatType;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public boolean isSeatAvailable() {
    return isSeatAvailable;
  }

  public void setSeatAvailable(boolean seatAvailable) {
    isSeatAvailable = seatAvailable;
  }
}
