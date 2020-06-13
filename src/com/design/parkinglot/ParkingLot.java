package com.design.parkinglot;

import com.design.parkinglot.common.Address;
import com.design.parkinglot.vehicle.Vehicle;

public class ParkingLot {

  private static ParkingLot parkingLot = null;
  private final int maxCompactSpotCount;
  private final int maxLargeSpotCount;
  private final int maxBikeSpotCount;
  private final int maxHandicappedSpotCount;
  private final int maxElectricSpotCount;
  private String name;
  private Address address;
  private int compactSpotCount;
  private int largeSpotCount;
  private int bikeSpotCount;
  private int handicappedSpotCount;
  private int electricSpotCount;

  private ParkingLot() {
    this.maxBikeSpotCount = 200;
    this.maxCompactSpotCount = 200;
    this.maxLargeSpotCount = 150;
    this.maxElectricSpotCount = 100;
    this.maxHandicappedSpotCount = 100;
    // init all the required data;
  }

  public static ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public int getCompactSpotCount() {
    return compactSpotCount;
  }

  public void setCompactSpotCount(int compactSpotCount) {
    this.compactSpotCount = compactSpotCount;
  }

  public int getLargeSpotCount() {
    return largeSpotCount;
  }

  public void setLargeSpotCount(int largeSpotCount) {
    this.largeSpotCount = largeSpotCount;
  }

  public int getBikeSpotCount() {
    return bikeSpotCount;
  }

  public void setBikeSpotCount(int bikeSpotCount) {
    this.bikeSpotCount = bikeSpotCount;
  }

  public int getHandicappedSpotCount() {
    return handicappedSpotCount;
  }

  public void setHandicappedSpotCount(int handicappedSpotCount) {
    this.handicappedSpotCount = handicappedSpotCount;
  }

  public int getElectricSpotCount() {
    return electricSpotCount;
  }

  public void setElectricSpotCount(int electricSpotCount) {
    this.electricSpotCount = electricSpotCount;
  }

  public void addParkingFloor(ParkingFloor floor) {}

  public void addEntrancePanel() {}

  public void addExitPanel() {}

  public boolean isFull() {
    return false;
  }

  public ParkingTicket getNewParkingTicket(Vehicle vehicle){
    return new ParkingTicket();
  }
}
