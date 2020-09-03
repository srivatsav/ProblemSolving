package com.design.hotel.entities;

import com.design.hotel.invoice.Invoice;

public class Server extends User {

  public boolean addRoomCharge(Room room, Invoice invoice) {
    return true;
  }
}
