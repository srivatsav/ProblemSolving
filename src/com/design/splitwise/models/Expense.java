package com.design.splitwise.models;

import java.util.List;

public abstract class Expense {

  private String id;
  private double amount;
  private User paidByUser;
  private ExpenseMetaData expenseMetaData;
  private List<Split> expenseSplits;

  public Expense(
      double amount,
      User paidByUser,
      ExpenseMetaData expenseMetaData,
      List<Split> expenseSplits) {
    this.amount = amount;
    this.paidByUser = paidByUser;
    this.expenseMetaData = expenseMetaData;
    this.expenseSplits = expenseSplits;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public User getPaidByUser() {
    return paidByUser;
  }

  public void setPaidByUser(User paidByUser) {
    this.paidByUser = paidByUser;
  }

  public ExpenseMetaData getExpenseMetaData() {
    return expenseMetaData;
  }

  public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
    this.expenseMetaData = expenseMetaData;
  }

  public List<Split> getExpenseSplits() {
    return expenseSplits;
  }

  public void setExpenseSplits(List<Split> expenseSplits) {
    this.expenseSplits = expenseSplits;
  }

  public abstract boolean validate();
}
