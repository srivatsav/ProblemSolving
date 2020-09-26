package com.design.splitwise.models;

public class PercentageSplit extends Split{

  double percentage;

  public PercentageSplit(User user, double percentage) {
    super(user);
    this.percentage = percentage;
  }

  public double getPercentage() {
    return percentage;
  }

  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }
}
