package com.design.hotel.invoice;

import java.util.Date;

public class RoomServiceCharges extends RoomCharges {
  private boolean isChargeable;
  private Date requestedTime;

  public boolean isChargeable() {
    return isChargeable;
  }

  public void setChargeable(boolean chargeable) {
    isChargeable = chargeable;
  }

  public Date getRequestedTime() {
    return requestedTime;
  }

  public void setRequestedTime(Date requestedTime) {
    this.requestedTime = requestedTime;
  }
}
