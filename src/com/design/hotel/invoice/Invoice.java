package com.design.hotel.invoice;

import java.util.Date;
import java.util.List;

public class Invoice {

  private double totalInvoiceAmount;
  private Date invoiceDate;
  private List<RoomCharges> splitCharges;

  public double getTotalInvoiceAmount() {
    return totalInvoiceAmount;
  }

  public void setTotalInvoiceAmount(double totalInvoiceAmount) {
    this.totalInvoiceAmount = totalInvoiceAmount;
  }

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public List<RoomCharges> getSplitCharges() {
    return splitCharges;
  }

  public void setSplitCharges(List<RoomCharges> splitCharges) {
    this.splitCharges = splitCharges;
  }
}
