package com.design.parkinglot.spot;

import com.design.parkinglot.vehicle.Vehicle;
import com.design.parkinglot.constants.ParkingLotConstants.ParkingSpotType;

public class ParkingSpot {
  private String number;
  private ParkingSpotType spotType;
  private Vehicle vehicle;
  private boolean isAvailable;

  public ParkingSpot(ParkingSpotType type) {
    this.spotType = type;
  };

  public boolean isAvailable() {
    return isAvailable;
  }

  public boolean assignVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.isAvailable = false;
    return true;
  }

  public boolean removeVehicle() {
    this.vehicle = null;
    this.isAvailable = true;
    return true;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ParkingSpotType getSpotType() {
    return spotType;
  }

  public void setSpotType(ParkingSpotType spotType) {
    this.spotType = spotType;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}
