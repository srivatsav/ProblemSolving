package com.design.parkinglot;

import com.design.parkinglot.spot.CompactSpot;
import com.design.parkinglot.spot.ElectricSpot;
import com.design.parkinglot.spot.HandicappedSpot;
import com.design.parkinglot.spot.LargeSpot;
import com.design.parkinglot.spot.MotorBikeSpot;

public class ParkingDisplayBoard {
  private String id;
  private HandicappedSpot handicappedFreeSpot;
  private CompactSpot compactFreeSpot;
  private LargeSpot largeFreeSpot;
  private MotorBikeSpot motorbikeFreeSpot;
  private ElectricSpot electricFreeSpot;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public HandicappedSpot getHandicappedFreeSpot() {
    return handicappedFreeSpot;
  }

  public void setHandicappedFreeSpot(HandicappedSpot handicappedFreeSpot) {
    this.handicappedFreeSpot = handicappedFreeSpot;
  }

  public CompactSpot getCompactFreeSpot() {
    return compactFreeSpot;
  }

  public void setCompactFreeSpot(CompactSpot compactFreeSpot) {
    this.compactFreeSpot = compactFreeSpot;
  }

  public LargeSpot getLargeFreeSpot() {
    return largeFreeSpot;
  }

  public void setLargeFreeSpot(LargeSpot largeFreeSpot) {
    this.largeFreeSpot = largeFreeSpot;
  }

  public MotorBikeSpot getMotorbikeFreeSpot() {
    return motorbikeFreeSpot;
  }

  public void setMotorbikeFreeSpot(MotorBikeSpot motorbikeFreeSpot) {
    this.motorbikeFreeSpot = motorbikeFreeSpot;
  }

  public ElectricSpot getElectricFreeSpot() {
    return electricFreeSpot;
  }

  public void setElectricFreeSpot(ElectricSpot electricFreeSpot) {
    this.electricFreeSpot = electricFreeSpot;
  }

  private void showEmptySpotsCount()
  {
    // show all the empty spots available for each spot type.
  }
}
