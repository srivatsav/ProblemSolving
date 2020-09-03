package com.design.hotel.invoice;

public class AmenityCharges extends RoomCharges {
  private String name;
  private String Description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }
}
