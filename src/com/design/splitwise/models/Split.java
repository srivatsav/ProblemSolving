package com.design.splitwise.models;

public abstract class Split {
  private User user;
   double amount;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  Split(User user) {
    this.user = user;
  }
}
