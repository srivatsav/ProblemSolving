package com.design.parkinglot.vehicle;

import com.design.parkinglot.ParkingTicket;
import com.design.parkinglot.constants.ParkingLotConstants.VehicleType;

public abstract class Vehicle {
  private String licenceNumber;
  private VehicleType vehicleType;
  private ParkingTicket parkingTicket;

  public Vehicle(VehicleType type){
    this.vehicleType = type;
  }

  public void assignTicket(ParkingTicket ticket){
    this.parkingTicket = ticket;
  }

  public String getLicenceNumber() {
    return licenceNumber;
  }

  public void setLicenceNumber(String licenceNumber) {
    this.licenceNumber = licenceNumber;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public ParkingTicket getParkingTicket() {
    return parkingTicket;
  }

  public void setParkingTicket(ParkingTicket parkingTicket) {
    this.parkingTicket = parkingTicket;
  }
}

