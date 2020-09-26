package com.design.splitwise.models;

import java.util.List;

public class PercentageExpense extends Expense{

  public PercentageExpense(double amount, User paidByUser,
      ExpenseMetaData expenseMetaData,
      List<Split> expenseSplits) {
    super(amount, paidByUser, expenseMetaData, expenseSplits);
  }

  @Override
  public boolean validate() {
    for(Split split : getExpenseSplits()) {
      if(!(split instanceof PercentageSplit))
        return false;
    }

    double totalPercentage = 100;
    double totalSumSplitPercent = 0;
    for(Split split : getExpenseSplits()) {
      PercentageSplit percentageSplit = (PercentageSplit) split;
      totalSumSplitPercent+=percentageSplit.getPercentage();
    }
    return totalSumSplitPercent==totalPercentage;
  }
}
