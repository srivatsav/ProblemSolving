package com.design.splitwise.models;

import java.util.List;

public class ExactExpense extends Expense {

  public ExactExpense(
      double amount, User paidByUser, ExpenseMetaData expenseMetaData, List<Split> expenseSplits) {
    super(amount, paidByUser, expenseMetaData, expenseSplits);
  }

  @Override
  public boolean validate() {
    for (Split split : getExpenseSplits()) {
      if (!(split instanceof ExactSplit)) return false;
    }
    double totalAmount = getAmount();
    double totalSumSplit = 0;

    for (Split split : getExpenseSplits()) {
      totalAmount += split.getAmount();
    }
    return totalAmount == totalSumSplit;
  }
}
