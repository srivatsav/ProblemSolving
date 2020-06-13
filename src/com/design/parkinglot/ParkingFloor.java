package com.design.parkinglot;

import com.design.parkinglot.spot.CompactSpot;
import com.design.parkinglot.spot.ElectricSpot;
import com.design.parkinglot.spot.HandicappedSpot;
import com.design.parkinglot.spot.LargeSpot;
import com.design.parkinglot.spot.MotorBikeSpot;
import com.design.parkinglot.spot.ParkingSpot;
import com.design.parkinglot.vehicle.Vehicle;
import java.util.Map;

public class ParkingFloor {
  private String name;
  private Map<String, CompactSpot> compactSpotMap;
  private Map<String, ElectricSpot> electricSpotMap;
  private Map<String, HandicappedSpot> handicappedSpotMap;
  private Map<String, LargeSpot> largeSpotMap;
  private Map<String, MotorBikeSpot> motorBikeSpotMap;

  ParkingFloor(String name) {
    this.name = name;
  }

  public void addParkingSpot(ParkingSpot spot) {
    switch (spot.getSpotType()) {
      case HANDICAPPED:
        handicappedSpotMap.put(spot.getNumber(), (HandicappedSpot) spot);
        break;
      case COMPACT:
        compactSpotMap.put(spot.getNumber(), (CompactSpot) spot);
        break;
      case LARGE:
        largeSpotMap.put(spot.getNumber(), (LargeSpot) spot);
        break;
      case MOTORBIKE:
        motorBikeSpotMap.put(spot.getNumber(), (MotorBikeSpot) spot);
        break;
      case ELECTRIC:
        electricSpotMap.put(spot.getNumber(), (ElectricSpot) spot);
        break;
      default:
        System.out.println("Wrong parking spot type!");
    }
  }

  public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
    parkingSpot.assignVehicle(vehicle);
    switch (parkingSpot.getSpotType()) {
      case MOTORBIKE:
        updateDisplayBoardForBike(parkingSpot);
        break;
      case COMPACT:
        updateDisplayBoardForCompact(parkingSpot);
        break;
      case HANDICAPPED:
        updateDisplayBoardForHandicapped(parkingSpot);
        break;
      default:
        System.out.println("Wrong parking spot !!");
        break;
    }
  }

  public void freeSpot(ParkingSpot spot) {
    spot.removeVehicle();
    // increase the display board count as well.
  }

  private void updateDisplayBoardForBike(ParkingSpot spot) {}

  private void updateDisplayBoardForCompact(ParkingSpot spot) {}

  private void updateDisplayBoardForHandicapped(ParkingSpot spot) {}
}
