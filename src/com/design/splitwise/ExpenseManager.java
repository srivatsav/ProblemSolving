package com.design.splitwise;

import com.design.splitwise.models.Expense;
import com.design.splitwise.models.ExpenseMetaData;
import com.design.splitwise.models.ExpenseType;
import com.design.splitwise.models.Split;
import com.design.splitwise.models.User;
import com.design.splitwise.service.ExpenseService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

  List<Expense> expenses;
  Map<String, User> userMap;
  Map<String, Map<String, Double>> balanceSheet;

  ExpenseManager() {
    expenses = new ArrayList<>();
    userMap = new HashMap<>();
    balanceSheet = new HashMap<>();
  }

  public boolean addUser(User user) {
    userMap.put(user.getUserId(), user);
    balanceSheet.put(user.getUserId(), new HashMap<String, Double>());
    return true;
  }

  public void addExpense(
      double amount,
      ExpenseType expenseType,
      String paidBy,
      List<Split> splits,
      ExpenseMetaData expenseMetaData) {

    Expense expense =
        ExpenseService.createExpense(
            expenseType, amount, userMap.get(paidBy), splits, expenseMetaData);

    expenses.add(expense);

    assert expense != null;
    for (Split split : expense.getExpenseSplits()) {
      String paidTo = split.getUser().getUserId();
      Map<String, Double> paidByBalanceSheet = balanceSheet.get(paidBy);
      if (!paidByBalanceSheet.containsKey(paidTo)) {
        paidByBalanceSheet.put(paidTo, 0.0);
      }
      paidByBalanceSheet.put(paidTo, paidByBalanceSheet.get(paidTo) + split.getAmount());

      Map<String, Double> paidToBalanceSheet = balanceSheet.get(paidTo);
      if (!paidToBalanceSheet.containsKey(paidBy)) {
        paidToBalanceSheet.put(paidBy, 0.0);
      }

      paidToBalanceSheet.put(paidBy, paidToBalanceSheet.get(paidBy) - split.getAmount());
    }
  }

  public void showBalance(String userId) {
    boolean isEmpty = true;
    Map<String, Double> map = balanceSheet.get(userId);
    for (Map.Entry<String, Double> entry : map.entrySet()) {
      if (entry.getValue() != 0) {
        isEmpty = false;
        printBalance(userId, entry.getKey(), entry.getValue());
      }
    }
    if (isEmpty) System.out.println("NO BALANCES");
  }

  public void showBalances() {
    boolean isEmpty = true;
    for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
      for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
        if (userBalance.getValue() > 0) {
          isEmpty = false;
          printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
        }
      }
    }

    if (isEmpty) {
      System.out.println("No balances");
    }
  }

  private void printBalance(String userId, String key, Double value) {
    String userName1 = userMap.get(userId).getName();
    String userName2 = userMap.get(key).getName();

    if (value > 0) {
      System.out.println(userName2 + " owes " + userName1 + " : " + Math.abs(value));
    } else if (value < 0) {
      System.out.println(userName1 + " owes " + userName2 + " : " + Math.abs(value));
    }
  }
}
