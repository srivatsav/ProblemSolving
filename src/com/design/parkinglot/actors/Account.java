package com.design.parkinglot.actors;

import com.design.parkinglot.common.Person;
import com.design.parkinglot.constants.ParkingLotConstants.AccountStatus;

/**
 * We will have two types of accounts in the system:
 * one for an Admin, and the other for a parking attendant.
 */
public abstract class Account {
  private String userName;
  private String password;
  private AccountStatus accountStatus;
  private Person person;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AccountStatus getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(
      AccountStatus accountStatus) {
    this.accountStatus = accountStatus;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
