package com.design.parkinglot.constants;

public class ParkingLotConstants {

  public enum VehicleType {
    CAR,
    TRUCK,
    ELECTRIC,
    VAN,
    MOTORBIKE
  }

  public enum ParkingSpotType {
    HANDICAPPED,
    ELECTRIC,
    COMPACT,
    LARGE,
    MOTORBIKE
  }

  public enum AccountStatus {
    ACTIVE,
    INACTIVE,
    BLOCKED,
    BANNED,
    ARCHIVED,
    UNKNOWN
  }

  public enum ParkingTicketStatus {
    ACTIVE,
    PAID,
    LOST
  }
}
