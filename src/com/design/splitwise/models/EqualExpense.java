package com.design.splitwise.models;

import java.util.List;

public class EqualExpense extends Expense{

  public EqualExpense(double amount, User paidByUser,
      ExpenseMetaData expenseMetaData,
      List<Split> expenseSplits) {
    super(amount, paidByUser, expenseMetaData, expenseSplits);
  }

  @Override
  public boolean validate() {
    for(Split split : getExpenseSplits()) {
      if(!(split instanceof EqualSplit)) {
        return false;
      }
    }
    return true;
  }
}
