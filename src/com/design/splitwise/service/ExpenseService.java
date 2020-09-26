package com.design.splitwise.service;

import com.design.splitwise.models.EqualExpense;
import com.design.splitwise.models.ExactExpense;
import com.design.splitwise.models.Expense;
import com.design.splitwise.models.ExpenseMetaData;
import com.design.splitwise.models.ExpenseType;
import com.design.splitwise.models.PercentageExpense;
import com.design.splitwise.models.PercentageSplit;
import com.design.splitwise.models.Split;
import com.design.splitwise.models.User;
import java.util.List;

public class ExpenseService {

  public static Expense createExpense(
      ExpenseType expenseType,
      double amount,
      User user,
      List<Split> splits,
      ExpenseMetaData expenseMetaData) {
    switch (expenseType) {
      case EXACT:
        return new ExactExpense(amount, user, expenseMetaData, splits);
      case PERCENTAGE:
        for (Split split : splits) {
          PercentageSplit percentageSplit = (PercentageSplit) split;
          percentageSplit.setAmount((amount * percentageSplit.getPercentage()) / 100.00);
        }
        return new PercentageExpense(amount, user, expenseMetaData, splits);
      case EQUAL:
        int splitSize = splits.size();
        double splitAmount = (double) Math.round(amount / splitSize);
        for (Split split : splits) {
          split.setAmount(splitAmount);
        }
        splits.get(0).setAmount(splitAmount + (amount - splitAmount * splitSize));
        return new EqualExpense(amount, user, expenseMetaData, splits);
      default:
        return null;
    }
  }
}
